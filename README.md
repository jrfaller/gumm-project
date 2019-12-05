# Reproduction experiment : gumm-project

This repository relates my experience in [ReScience's ten-year challenge](https://rescience.github.io/ten-years/) Ten Years Reproducibility Challenge. The objective of this challenge is to try to run the code I’ve created for a scientific publication that was published more than ten years ago. I have to try to make my old code to run on modern hardware/software (with minimal modifications) in order to check if I can obtain the exact same results that were publised at least ten years ago. I chose the article [Metamodel Matching for Automatic Model Transformation Generation](https://hal-lirmm.ccsd.cnrs.fr/lirmm-00322879/), published in the MoDELS 2009 conference to tackle this challenge.

## Finding the source

I quickly run into a first bug problem: there is no link to the source code in the paper. Fortunately, I remember that I used a repository on google code to store the code, and I remember the original name of the project : gumm-project therefore I try to retrieve the code there.
I am not successful with the original google code repository that was shutdown. When trying to access the archive, I get a `401: Anonymous caller does not have storage.objects.get access to google-code-archive/v2/code.google.com/gumm-project/downloads-page-1.json` error.
Luckily, I am able to retrieve it using [software heritage](https://archive.softwareheritage.org/browse/origin/http://gumm-project.googlecode.com/svn//directory/).
Unfortunately, I am unable to find the exact version of the code used in the article therefore I could stop here because I could not comply with the challenge. However, it would be no fun at all. Therefore, I will try to run the latest version in the remainder.

## Compiling the source

There is no build file in the project, so I decide to port it to Gradle. Thanks to a versioned Eclipse config file, I spot that I have dependencies to Java 1.4 and Junit 4. I also spot in a lib folder a dependency to `simmetrics_jar_v1_6_2_d07_02_07.jar` and to a homemade `com.googlecode.exputils.jar`. I manage to retrieve the JUnit dependency from [Maven Central](https://search.maven.org/). Simmetrics is available there, but I run into errors when trying to put it as a managed dependency because the file with the same version seems to be unavailable on the registry. A more recent version can be downloaded just fine but I get compile errors. However, since I had the good idea to store the jar file, this is not a big problem, as it is the case for `com.googlecode.exputils.jar`.

## Running the program

Another big problem: there is no manual at all, and I cannot quikcly find out how to run the code. Therefore, I resort to reading the source code, looking for main methods, which I cannot find. With a more in-depth reading, I notice that there is no "API" that performs high-level processing in the code, there are only building blocks that I have to connect by hand. Fortunately, I wrote unit tests that help me to understand how to use these building blocks. Therefore I want to start using them, but then I realize that I have a big issue. The code is supposed to work on graphs, but I have not included in the source code the components that import these graphs. Therefore I have no data to run my code against! Worse, it seems that finding this code is not possible as it was never versioned for an unexplainable reason. Everything is lost!

Everything? Fortunately I am a pretty persistent person and I suddenly have a very good idea : looking in my e-mails. This is indeed a very good idea because I find there several mails where I sent the missing pieces of code to fellow researchers that were brave enough to run my tools. Therefore I manage to get the graph importer code as well as the dataset.

Unfortunately, my feeling of joy is short-lived. After adding one more jar file to the dependencies (`nlpse.jar`) and spending ten minutes figuring out two good Maven Central dependencies for two other dependencies (Ecore and XMI), I realize that the source code of my graph importer must be based upon an older version of gumm-project, I have a bunch of compilation errors, probably due to many refactorings being applied (notably a rename package, and several rename classes). I go for it, fixing the compilation errors one by one. Some of them are easy, but I am highly unsure of some other fixes, so I annotate them with a `FIXME` comment. After roughly one hour, the code is finally compiling, I run the program against two elements of the dataset, and finally I get an output!

```
Left graph: Adjacent input graph with 238 nodes and 555 edges. Is ok: false
Right graph: Adjacent input graph with 367 nodes and 1080 edges. Is ok: false
Creating connectivity graph.
Connectivity graph: Connectivity Graph with: 40546 nodes and with 72802 edges.
Creating propagation graph.
Propagation graph: Connectivity Graph with: 40546 nodes and with 145604 edges.
Propagation Graph with: 40546 nodes and with 145604 edges.
Flooding.
Filtering step.
Number of matches after filtering: 250
Computation time: 0.06711667 mins.
```

As you might have noticed if you read the previous output, I am highly unsure about the previous results, for instance I really do not like the `Is ok: false` in the first two lines. Clearly the code needs debugging. Before going at it, I decide to create a GitHub repository to avoid losing everything (again :D).
