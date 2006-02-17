What is a branch? (Subversion Handbook pp. 42)

Suppose it's your job to maintain a document for a division in your company, a handbook of some sort. One day a
different division asks you for the same handbook, but with a few parts “tweaked” for them, since they do things
slightly differently.

What do you do in this situation? You do the obvious thing: you make a second copy of your document, and begin
maintaining the two copies separately. As each department asks you to make small changes, you incorporate them
into one copy or the other.

You often want to make the same change to both copies. For example, if you discover a typo in the first copy, it's
very likely that the same typo exists in the second copy. The two documents are almost the same, after all; they only
differ in small, specific ways.

This is the basic concept of a branch—namely, a line of development that exists independently of another line, yet
still shares a common history if you look far enough back in time. A branch always begins life as a copy of some-
thing, and moves on from there, generating its own history.


Creating a Branch

Creating a branch is very simple—you make a copy of the project in the repository using the svn copy command.
Subversion is not only able to copy single files, but whole directories as well. In this case, you want to make a copy
of the /calc/trunk directory. Where should the new copy live? Wherever you wish—it's a matter of project pol-
icy. Let's say that your team has a policy of creating branches in the /calc/branches area of the repository, and
you want to name your branch my-calc-branch. You'll want to create a new directory, /
calc/branches/my-calc-branch, which begins its life as a copy of /calc/trunk.
There are two different ways to make a copy. We'll demonstrate the messy way first, just to make the concept clear.
To begin, check out a working copy of the project's root directory, /calc:

$ svn checkout http://svn.example.com/repos/calc bigwc
A bigwc/trunk/
A bigwc/trunk/Makefile
A bigwc/trunk/integer.c
A bigwc/trunk/button.c
A bigwc/branches/
Checked out revision 340.

Making a copy is now simply a matter of passing two working-copy paths to the svn copy command:

$ cd bigwc
$ svn copy trunk branches/my-calc-branch
$ svn status
A+          branches/my-calc-branch

In this case, the svn copy command recursively copies the trunk working directory to a new working directory,
branches/my-calc-branch. As you can see from the svn status command, the new directory is now sched-
uled for addition to the repository. But also notice the “+” sign next to the letter A. This indicates that the scheduled
addition is a copy of something, not something new. When you commit your changes, Subversion will create /
calc/branches/my-calc-branch in the repository by copying /calc/trunk, rather than resending all of
the working copy data over the network:

$ svn commit -m "Creating a private branch of /calc/trunk."
Adding                  branches/my-calc-branch
Committed revision 341.

And now the easier method of creating a branch, which we should have told you about in the first place: svn copy is
able to operate directly on two URLs.

$ svn copy http://svn.example.com/repos/calc/trunk \
                  http://svn.example.com/repos/calc/branches/my-calc-branch \
          -m "Creating a private branch of /calc/trunk."
Committed revision 341.

There's really no difference between these two methods. Both procedures create a new directory in revision 341, and
the new directory is a copy of /calc/trunk. This is shown in Figure 4.3, “Repository with new copy”. Notice
that the second method, however, performs an immediate commit. 7 It's an easier procedure, because it doesn't re-
quire you to check out a large mirror of the repository. In fact, this technique doesn't even require you to have a
working copy at all.

