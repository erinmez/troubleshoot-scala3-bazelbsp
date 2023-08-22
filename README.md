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

