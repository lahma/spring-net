// ------------------------------------------------------------------------------
// <auto-generated>
//
//     This code was generated.
//
//     - To turn off auto-generation set:
//
//         [TeamCity (AutoGenerate = false)]
//
//     - To trigger manual generation invoke:
//
//         nuke --generate-configuration TeamCity --host TeamCity
//
// </auto-generated>
// ------------------------------------------------------------------------------

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildFeatures.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.*

version = "2021.1"

project {
    buildType(Pack)
    buildType(Test_P1T5)
    buildType(Test_P2T5)
    buildType(Test_P3T5)
    buildType(Test_P4T5)
    buildType(Test_P5T5)
    buildType(Test)

    buildTypesOrder = arrayListOf(Pack, Test_P1T5, Test_P2T5, Test_P3T5, Test_P4T5, Test_P5T5, Test)

    params {
        checkbox (
            "env.BuildEms",
            label = "BuildEms",
            description = "Build EMS",
            value = "False",
            checked = "True",
            unchecked = "False",
            display = ParameterDisplay.NORMAL)
        select (
            "env.Configuration",
            label = "Configuration",
            description = "Configuration to build - Default is 'Debug' (local) or 'Release' (server)",
            value = "Release",
            options = listOf("Debug" to "Debug", "Release" to "Release"),
            display = ParameterDisplay.NORMAL)
        password (
            "env.GitHubRegistryApiKey",
            label = "GitHubRegistryApiKey",
            value = "",
            display = ParameterDisplay.NORMAL)
        text (
            "env.ProjectVersion",
            label = "ProjectVersion",
            description = "Version",
            value = "3.0.0",
            allowEmpty = true,
            display = ParameterDisplay.NORMAL)
        password (
            "env.PublicNuGetApiKey",
            label = "PublicNuGetApiKey",
            value = "",
            display = ParameterDisplay.NORMAL)
        checkbox (
            "env.TestFull",
            label = "TestFull",
            value = "False",
            checked = "True",
            unchecked = "False",
            display = ParameterDisplay.NORMAL)
        checkbox (
            "env.TestIntegrationData",
            label = "TestIntegrationData",
            value = "False",
            checked = "True",
            unchecked = "False",
            display = ParameterDisplay.NORMAL)
        checkbox (
            "env.TestIntegrationEms",
            label = "TestIntegrationEms",
            value = "False",
            checked = "True",
            unchecked = "False",
            display = ParameterDisplay.NORMAL)
        checkbox (
            "env.TestIntegrationMsMq",
            label = "TestIntegrationMsMq",
            value = "False",
            checked = "True",
            unchecked = "False",
            display = ParameterDisplay.NORMAL)
        checkbox (
            "env.TestIntegrationNms",
            label = "TestIntegrationNms",
            value = "False",
            checked = "True",
            unchecked = "False",
            display = ParameterDisplay.NORMAL)
        select (
            "env.Verbosity",
            label = "Verbosity",
            description = "Logging verbosity during build execution. Default is 'Normal'.",
            value = "Normal",
            options = listOf("Minimal" to "Minimal", "Normal" to "Normal", "Quiet" to "Quiet", "Verbose" to "Verbose"),
            display = ParameterDisplay.NORMAL)
        text(
            "teamcity.runner.commandline.stdstreams.encoding",
            "UTF-8",
            display = ParameterDisplay.HIDDEN
        )
    }
}
object Pack : BuildType({
    name = "Pack"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.cmd"
            arguments = "Restore Pack --skip"
            conditions { contains("teamcity.agent.jvm.os.name", "Windows") }
        }
        exec {
            path = "build.sh"
            arguments = "Restore Pack --skip"
            conditions { doesNotContain("teamcity.agent.jvm.os.name", "Windows") }
        }
    }
    params {
        text(
            "teamcity.ui.runButton.caption",
            "Pack",
            display = ParameterDisplay.HIDDEN
        )
    }
    triggers {
        vcs {
            triggerRules = "+:**"
        }
    }
})
object Test_P1T5 : BuildType({
    name = "Test 1/5"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.cmd"
            arguments = "Restore Compile Test --skip --test-partition 1"
            conditions { contains("teamcity.agent.jvm.os.name", "Windows") }
        }
        exec {
            path = "build.sh"
            arguments = "Restore Compile Test --skip --test-partition 1"
            conditions { doesNotContain("teamcity.agent.jvm.os.name", "Windows") }
        }
    }
})
object Test_P2T5 : BuildType({
    name = "Test 2/5"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.cmd"
            arguments = "Restore Compile Test --skip --test-partition 2"
            conditions { contains("teamcity.agent.jvm.os.name", "Windows") }
        }
        exec {
            path = "build.sh"
            arguments = "Restore Compile Test --skip --test-partition 2"
            conditions { doesNotContain("teamcity.agent.jvm.os.name", "Windows") }
        }
    }
})
object Test_P3T5 : BuildType({
    name = "Test 3/5"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.cmd"
            arguments = "Restore Compile Test --skip --test-partition 3"
            conditions { contains("teamcity.agent.jvm.os.name", "Windows") }
        }
        exec {
            path = "build.sh"
            arguments = "Restore Compile Test --skip --test-partition 3"
            conditions { doesNotContain("teamcity.agent.jvm.os.name", "Windows") }
        }
    }
})
object Test_P4T5 : BuildType({
    name = "Test 4/5"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.cmd"
            arguments = "Restore Compile Test --skip --test-partition 4"
            conditions { contains("teamcity.agent.jvm.os.name", "Windows") }
        }
        exec {
            path = "build.sh"
            arguments = "Restore Compile Test --skip --test-partition 4"
            conditions { doesNotContain("teamcity.agent.jvm.os.name", "Windows") }
        }
    }
})
object Test_P5T5 : BuildType({
    name = "Test 5/5"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.cmd"
            arguments = "Restore Compile Test --skip --test-partition 5"
            conditions { contains("teamcity.agent.jvm.os.name", "Windows") }
        }
        exec {
            path = "build.sh"
            arguments = "Restore Compile Test --skip --test-partition 5"
            conditions { doesNotContain("teamcity.agent.jvm.os.name", "Windows") }
        }
    }
})
object Test : BuildType({
    name = "Test"
    type = Type.COMPOSITE
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
        showDependenciesChanges = true
    }
    artifactRules = "**/*"
    params {
        text(
            "teamcity.ui.runButton.caption",
            "Test",
            display = ParameterDisplay.HIDDEN
        )
    }
    triggers {
        vcs {
            triggerRules = "+:**"
        }
    }
    dependencies {
        snapshot(Test_P1T5) {
            onDependencyFailure = FailureAction.ADD_PROBLEM
            onDependencyCancel = FailureAction.CANCEL
        }
        snapshot(Test_P2T5) {
            onDependencyFailure = FailureAction.ADD_PROBLEM
            onDependencyCancel = FailureAction.CANCEL
        }
        snapshot(Test_P3T5) {
            onDependencyFailure = FailureAction.ADD_PROBLEM
            onDependencyCancel = FailureAction.CANCEL
        }
        snapshot(Test_P4T5) {
            onDependencyFailure = FailureAction.ADD_PROBLEM
            onDependencyCancel = FailureAction.CANCEL
        }
        snapshot(Test_P5T5) {
            onDependencyFailure = FailureAction.ADD_PROBLEM
            onDependencyCancel = FailureAction.CANCEL
        }
        artifacts(Test_P1T5) {
            artifactRules = "**/*"
        }
        artifacts(Test_P2T5) {
            artifactRules = "**/*"
        }
        artifacts(Test_P3T5) {
            artifactRules = "**/*"
        }
        artifacts(Test_P4T5) {
            artifactRules = "**/*"
        }
        artifacts(Test_P5T5) {
            artifactRules = "**/*"
        }
    }
})
