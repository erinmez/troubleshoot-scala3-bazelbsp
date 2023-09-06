Repo to reproduce a bazel-bsp issue where it does not add the source dependencies to IntelliJ's project model when `derive_targets_from_directories` is set to true in `projectview.bazelproject` (set to false works) (https://youtrack.jetbrains.com/issue/BAZEL-596):

- bazel version is 6.3.2
- Scala is 3.3.0
- contains simple hello world done with ZIO framework to have a Bazel+Scala3 project that also downloads maven dependencies.
- runnable with `bazel run //foo/src/main/scala/foo:app`

Steps to reproduce:
1. `git clone https://github.com/erinmez/troubleshoot-scala3-bazelbsp`
1. `cs launch org.jetbrains.bsp:bazel-bsp:3.0.0-20230902-1716735-NIGHTLY -M org.jetbrains.bsp.bazel.install.Install`
1. In IntelliJ IDEA:

   1. File -\> New Project from Existing Sources...
   
   1. Select this project troubleshoot-scala3-bazelbsp
   
   1. Select BSP
1. in projectview.bazelproject set `derive_targets_from_directories: true` and press "Reload BSP Project" in the BSP panel.
   
   -> Navigate to any symbol that is in a 3rd party package, the editor will open a *.tasty file. Proper behavior should be to open a *.scala source file.

<br>
Previous Issue which is solved:
<details>
  <summary>Scala 3 not detected in Bazel BSP (solved in the nightly build or > 3.0.0)</summary>
<br>
Repo to reproduce a bazel-bsp issue where it is not able to locate the SDK with newer Scala 3 versions (https://youtrack.jetbrains.com/issue/BAZEL-404):

- bazel version is 6.3.2
- Scala is 3.3.0
- contains simple hello world done with ZIO framework to have a Bazel+Scala3 project that also downloads maven dependencies.
- runnable with `bazel run //foo/src/main/scala/foo:app`

Steps to reproduce:
1. install bazel-bsp via:

   `cs launch org.jetbrains.bsp:bazel-bsp:3.0.0 -M org.jetbrains.bsp.bazel.install.Install`

2. In IntelliJ IDEA:
   1.  File -> New Project from Existing Sources...
   2. Select this project troubleshoot-scala3-bazelbsp
   3. Select BSP

3. check log file `.bazelbsp/bazelbsp.log`. There should be an error entry at the bottom:
   
   `org.eclipse.lsp4j.jsonrpc.ResponseErrorException: java.lang.RuntimeException: Failed to resolve Scala SDK for project`

</details>
