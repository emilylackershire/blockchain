## Comments 

You are in the right track! Some methods are not fully implemented yet. It may be useful to spend some time debugging the references to null nodes, which seems to cause an error in the append method. Once you fix those methods, test your program with the examples from the website.
Make sure you add javadoc comments to your program and be careful with indentation. Run `mvn checkstyle:check` to get a list of style violations. Aim for less than 3 style errors for an E.

## Changes Made

To start off, I fixed the style errors! (I couldn't get checkstyle to run previously, but figured it out!)

I then changed my append method so it was working better. 

I started by realizing I wasn't even using the .append methd even though I wrote that, I was instead trying to manually do it which makes no sense.

I then realized I wasn't mining the nonce correctly, and it was just giving back 0 each time which wasn't what I wanted. This was due to an issue with my while loop in mine. 

I was then getting an error in my in append because getHash was returning null, and I realized this was because it wasn't actually being initialized in my block class. I initialized it, and made sure it was getting the nonce in append. I also made sure the balances were actually being updated, so now that works!


