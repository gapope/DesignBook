# Chapter 1 Practice Exercises

## Exercise 1

Rewrite [TwelveDays](../chapter-code/chapter1/TwelveDays.java) in an iterative style, as opposed to recursive. What is the impact of this change on the design? Does this change move the solution in the design space? If so, how?

### Response

The change is restricted to the one function so has minimal impact on the design. It could be more readable for people unfamiliar with recursion, but otherwise this solution should be at a similar point in the design space to the original.

## Exercise 2

Change [TwelveDays](../chapter-code/chapter1/TwelveDays.java) so that it is possible to choose between displaying the number of the days written out (for example "third" day), as in the original version, or using digits (for example "3rd day"). If the user includes the command-line argument "digit", the program should use digits. In all other cases, the original, written-out form should be used. What is the impact of your solution on the quality attributes of the design?

### Response

This adds an abstraction of the day string. Additionally, a check for the arguments is implemented. In this case I made this a single line which sets the `digits` flag, but if more than one argument was to be supported it would likely make sense for this to be handled by an `checkArguments(args)` method or an abstraction for each flag to be set.

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019