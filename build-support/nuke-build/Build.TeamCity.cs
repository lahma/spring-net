using Nuke.Common.CI.TeamCity;

[TeamCity(
    AutoGenerate = true,
    Version = "2021.1",
    VcsTriggeredTargets = new[] { nameof(Pack), nameof(Test) },
    NonEntryTargets = new[] { nameof(Restore), nameof(Compile) }
)]
public partial class Build
{
}