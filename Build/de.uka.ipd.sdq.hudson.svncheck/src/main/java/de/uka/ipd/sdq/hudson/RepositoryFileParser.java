package de.uka.ipd.sdq.hudson;

import hudson.model.BuildListener;

import java.util.LinkedList;
import java.util.List;

import org.tmatesoft.svn.core.ISVNDirEntryHandler;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNLogClient;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class RepositoryFileParser {
    public List<String> parseFile(BuildListener listener, String rootPath, String username, String password) {
        final LinkedList<String> entries = new LinkedList<String>();
        
        SVNClientManager ourClientManager;
        
        org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions options = SVNWCUtil.createDefaultOptions(true);
        
        if (username != null && password != null) {
            ourClientManager = SVNClientManager.newInstance(options, username, password);
        } else {
            ourClientManager = SVNClientManager.newInstance(options);
        }
        
        try {
            SVNURL url = SVNURL.parseURIDecoded(rootPath);
            ourClientManager.createRepository(url, true);
            SVNLogClient logger = ourClientManager.getLogClient();
            
            //Get all first-level foldernames
            logger.doList(url, SVNRevision.HEAD, SVNRevision.HEAD, false, SVNDepth.IMMEDIATES, SVNDirEntry.DIRENT_ALL, new ISVNDirEntryHandler() {
                public void handleDirEntry(SVNDirEntry entry) throws SVNException {
                    //Only take directories and exclude the url itself (usually it's included as well)
                    if (entry.getKind() == SVNNodeKind.DIR && !entry.getRelativePath().equals("")) {
                        entries.add(entry.getURL().toString());
                    }
                }
            });
        } catch (SVNException e) {
            listener.getLogger().println("SVNException: " + e.getErrorMessage().getFullMessage());
        }
        
        return entries;
    }
}
