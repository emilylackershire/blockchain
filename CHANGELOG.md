## Comments 

You are in the right track! Some methods are not fully implemented yet. It may be useful to spend some time debugging the references to null nodes, which seems to cause an error in the append method. Once you fix those methods, test your program with the examples from the website.
Make sure you add javadoc comments to your program and be careful with indentation. Run `mvn checkstyle:check` to get a list of style violations. Aim for less than 3 style errors for an E.

## Changes Made

To start off, I fixed the style errors! (I couldn't get checkstyle to run previously, but figured it out!)

I then changed my append method so it was working better. 

if (blk.getHash().isValid() && blk.getHash() != blk.getPrevHash()) {
            Node newNode = new Node(blk, null);
            last.next = newNode;
        } else {
            throw new IllegalArgumentException();
        }