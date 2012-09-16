package de.uka.ipd.sdq.hudson;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.scm.SubversionSCM;
import hudson.scm.SubversionSCM.ModuleLocation;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

import org.kohsuke.stapler.DataBoundConstructor;

public class NotBuiltRepositoriesPublisher extends Recorder {
  public String repositories;
  public String exclusions;
  public String username;
  public String password;
  public boolean optionalCredentials;
  
  public BuildStepMonitor getRequiredMonitorService() {
      return BuildStepMonitor.NONE;
  }
  
  @DataBoundConstructor
  public NotBuiltRepositoriesPublisher(String repositories, String exclusions, boolean optionalCredentials, String username, String password) {
      if (repositories != null) {
          this.repositories = repositories;
      } else {
          this.repositories = "";
      }
      
      if (exclusions != null) {
          this.exclusions = exclusions;
      } else {
          this.exclusions = "";
      }
      
      if (username != null) {
          this.username = username;
      } else {
          this.username = "";
      }
      
      if (password != null) {
          this.password = password;
      } else {
          this.password = "";
      }
      
      this.optionalCredentials = optionalCredentials;
  }
  
  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) {        
      //Tokenise repository paths
      StringTokenizer tokenizer = new StringTokenizer(repositories,"\n");
      List<String> repositoryList = new LinkedList<String>();
      while (tokenizer.hasMoreElements()) {
          repositoryList.add(tokenizer.nextToken());
      }
      
      //Tokenise exclusion paths
      tokenizer = new StringTokenizer(exclusions, "\n");
      List<String> exclusionList = new LinkedList<String>();
      while (tokenizer.hasMoreElements()) {
          exclusionList.add(tokenizer.nextToken());
      }
      
      //Extracting SVN projects which are being checked out in the job
      List<String> checkedOutProjects = new LinkedList<String>();
      
      if (build.getProject().getScm() instanceof SubversionSCM) {
          SubversionSCM scmInstance = (SubversionSCM) build.getProject().getScm();
          for (ModuleLocation currentLoc : scmInstance.getLocations()) {
              checkedOutProjects.add(currentLoc.getURL());
          }
      }
      
      //Get all projects in all repository paths
      RepositoryFileParser parser = new RepositoryFileParser();
      
      List<String> resultingProjects = new LinkedList<String>();
      for (String currentRepository : repositoryList) {
          if (optionalCredentials) {
              listener.getLogger().println("Using svn credentials...");
              resultingProjects.addAll(parser.parseFile(listener, currentRepository, username, password));
          } else {
              resultingProjects.addAll(parser.parseFile(listener, currentRepository, null, null));
          }
      }
      
      //Remove checked out projects from all projects
      for (String currentProject : checkedOutProjects) {
          resultingProjects.remove(currentProject);
      }
      
      //Remove exclusions
      for (String currentExclusion : exclusionList) {
          //Handle wildcards at the end of the exclusion string
          if (currentExclusion.endsWith("*")) {
              String tempExclusion = currentExclusion.substring(0, currentExclusion.length()-1);
              ListIterator<String> projectIterator = resultingProjects.listIterator();
              while (projectIterator.hasNext()) {
                  String currentProject = projectIterator.next();
                  if (currentProject.startsWith(tempExclusion)) {
                      projectIterator.remove();
                  }
              }
          } else {
              ListIterator<String> projectIterator = resultingProjects.listIterator();
              while (projectIterator.hasNext()) {
                  String currentProject = projectIterator.next();
                  if (currentProject.equals(currentExclusion)) {
                      projectIterator.remove();
                  }
              }
          }
      }

      NotBuiltRepositoriesAction action = new NotBuiltRepositoriesAction(resultingProjects);
      build.getActions().add(action);
      
      return true;
  }
  
  // Overridden for better type safety.
  // If your plugin doesn't really define any property on Descriptor,
  // you don't have to do this.
  @Override
  public DescriptorImpl getDescriptor() {
      return (DescriptorImpl) super.getDescriptor();
  }
  
  @Extension
  public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

      public DescriptorImpl() {
          super(NotBuiltRepositoriesPublisher.class);
      }
      
      @Override
      public String getDisplayName() {
          return "Publish SVN repository report";
      }

      @Override
      public boolean isApplicable(Class<? extends AbstractProject> jobType) {
          return true;
      }
  }

}
