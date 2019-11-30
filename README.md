# Reproduction experiment : gumm-project

This project relates my experience in [ReScience's ten-year challenge](https://rescience.github.io/ten-years/) Ten Years Reproducibility Challenge.

## Finding the source

First problem, no link to the code in the paper. Fortunately, I remember that I used a repository on google code to store the code, and I remember the original name of the project : gumm-project therefore I try to retrieve the code there.

No luck with the original google code repo that was shutdown. I got a `401: Anonymous caller does not have storage.objects.get access to google-code-archive/v2/code.google.com/gumm-project/downloads-page-1.json` when trying to access the file.

Successfully find it using [software heritage](https://archive.softwareheritage.org/browse/origin/http://gumm-project.googlecode.com/svn//directory/).

Unfortunately, I am unable to find the exact version of the article therefore I will try to build the latest version in the remainder.

## Compiling the source

There is no build file in the project, so I decide to port it to Gradle. Thanks to a versioned Eclipse config file, I spot that I have dependencies to Java 1.4 and Junit 4. I also spot in a lib folder a dependency to `simmetrics_jar_v1_6_2_d07_02_07.jar` and to a homemade `com.googlecode.exputils.jar`. I manage to retrieve the JUnit dependency from mavencentral. Simmetrics is available on mavencentral but I run into errors when trying to put it as a managed dependency because the file with the same version seems to be not available on the registry. A more recent version can be downloaded just fine but I get compile errors. However, since I had the code idea to store the jar, this is not a big problem, as it is the case for `com.googlecode.exputils.jar`.

## Running the program

Mmm problem there is no manual, so I resort to reading the source code, looking for main methods, which I cannot find. With a more in-depth reading, I notice that there is no "API" that performs high-level processing in the code, there are only building blocks that I have to connect by hand. Fortunately, I wrote unit tests that helps to understand how to use these building blocks. Therefore I want to start using them, but then I realize that I have a big issue. The code is supposed to work on graphs, but I have not included in the source code the components that import these graphs... Therefore I have no data to run my code against! Worse, it seems that finding this code is not possible as it was never versioned for an unexplainable reason. Therefore everything is lost!

Everything? Fortunately I am a pretty persistent person and I suddenly have a very good idea : looking in my e-mails. This is indeed a very good idea because I find there several mails where I sent the missing pieces of code to fellow researchers that were willing to run my tools. Therefore I manage to get the graph importer code as well as the dataset.

Unfortunately, my feeling of joy is short-lived. After adding one more jar file to the dependencies (`nlpse.jar`) and spending ten minutes figuring out two good maven central dependencies for Ecore and XMI, I realize that the source code of my graph imported must be based upon an older version of gumm-project, I have a bunch of compilation errors, probably due to many refactorings being applied (notably a rename package, and several rename classes, etc.). I go for it, removing the compilation errors one by one. Some of them are easy, but I am highly unsure of some other fixes, so I annotate them with a `FIXME` comment. After roughly one hour, the code is finally compiling, I run the program against two elements of the dataset, and finally I get an output!


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