Tags (Subversion Handbook pp.61)

Another common version control concept is a tag. A tag is just a “snapshot” of a project in time. In Subversion, this
idea already seems to be everywhere. Each repository revision is exactly that—a snapshot of the filesystem after
each commit.

However, people often want to give more human-friendly names to tags, like release-1.0. And they want to
make snapshots of smaller subdirectories of the filesystem. After all, it's not so easy to remember that release-1.0 of
a piece of software is a particular subdirectory of revision 4822.


Creating a Simple Tag

Once again, svn copy comes to the rescue. If you want to create a snapshot of /calc/trunk exactly as it looks in
the HEAD revision, then make a copy of it:

$ svn copy http://svn.example.com/repos/calc/trunk \
                   http://svn.example.com/repos/calc/tags/release-1.0 \
           -m "Tagging the 1.0 release of the 'calc' project."
Committed revision 351.

This example assumes that a /calc/tags directory already exists. (If it doesn't, see svn mkdir). After the copy
completes, the new release-1.0 directory is forever a snapshot of how the project looked in the HEAD revision
at the time you made the copy. Of course you might want to be more precise about exactly which revision you copy,
in case somebody else may have committed changes to the project when you weren't looking. So if you know that
revision 350 of /calc/trunk is exactly the snapshot you want, you can specify it by passing -r 350 to the svn
copy command.

But wait a moment: isn't this tag-creation procedure the same procedure we used to create a branch? Yes, in fact, it
is. In Subversion, there's no difference between a tag and a branch. Both are just ordinary directories that are created
by copying. Just as with branches, the only reason a copied directory is a “tag” is because humans have decided to
treat it that way: as long as nobody ever commits to the directory, it forever remains a snapshot. If people start com-
mitting to it, it becomes a branch.

If you are administering a repository, there are two approaches you can take to managing tags. The first approach is
“hands off”: as a matter of project policy, decide where your tags will live, and make sure all users know how to
treat the directories they copy in there. (That is, make sure they know not to commit to them.) The second approach
is more paranoid: you can use one of the access-control scripts provided with Subversion to prevent anyone from
doing anything but creating new copies in the tags-area (See Chapter 6, Server Configuration.) The paranoid ap-
proach, however, isn't usually necessary. If a user accidentally commits a change to a tag-directory, you can simply
undo the change as discussed in the previous section. This is version control, after all.


Creating a Complex Tag

Sometimes you may want your “snapshot” to be more complicated than a single directory at a single revision.
For example, pretend your project is much larger than our calc example: suppose it contains a number of subdirec-
tories and many more files. In the course of your work, you may decide that you need to create a working copy that
is designed to have specific features and bug fixes. You can accomplish this by selectively backdating files or direc-
tories to particular revisions (using svn update -r liberally), or by switching files and directories to particular
branches (making use of svn switch). When you're done, your working copy is a hodgepodge of repository locations
from different revisions. But after testing, you know it's the precise combination of data you need.

Time to make a snapshot. Copying one URL to another won't work here. In this case, you want to make a snapshot
of your exact working copy arrangement and store it in the repository. Luckily, svn copy actually has four different
uses (which you can read about in Chapter 9), including the ability to copy a working-copy tree to the repository:

$ ls
my-working-copy/
$ svn copy my-working-copy http://svn.example.com/repos/calc/tags/mytag
Committed revision 352.

Now there is a new directory in the repository, /calc/tags/mytag, which is an exact snapshot of your working
copy—mixed revisions, URLs, and all.

Other users have found interesting uses for this feature. Sometimes there are situations where you have a bunch of
local changes made to your working copy, and you'd like a collaborator to see them. Instead of running svn diff and
sending a patch file (which won't capture tree changes), you can instead use svn copy to “upload” your working
copy to a private area of the repository. Your collaborator can then either checkout a verbatim copy of your working
copy, or use svn merge to receive your exact changes.

