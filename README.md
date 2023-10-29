# minecraft-mod
## Introduction

This project contains the PHRED Robotics minecraft mod.
The mod is automatically deployed to the Minecraft server whenever a new release is created.
The PHRED mod can be downloaded at https://github.com/PHREDRobotics/minecraft-mod/releases.
The server should always match the latest version on that page.
In addition, the mod depends on the following libraries:
- https://maven.fabricmc.net/net/fabricmc/fabric-api/fabric-api/0.84.0%2B1.19.4/fabric-api-0.84.0%2B1.19.4.jar
- https://www.curseforge.com/minecraft/mc-mods/geckolib/files/4568325

The Minecraft server can be connected to on the standard port at mc-phred.4dlochstudios.com

## Development Quickstart
- Open the project in VS Code
- Run "./gradlew vscode" to generate the launch profiles
- Write some code
- Click "Run and Debug" or press "Ctrl+Shift+D"
- Click the Play symbol next to "Minecraft Client"

## Deployment
To create a new release and automatically deploy it to the server, you will need to tag a new release on the main branch.
Note: The current build.yml will only allow deployment from tags
1) Decide on a new version number following the "{major}.{minor}.{build}" version pattern
2) Go to https://github.com/PHREDRobotics/minecraft-mod/blob/main/gradle.properties
3) Edit the line for version with the new version number
Go to https://github.com/PHREDRobotics/minecraft-mod/releases
4) Click "Draft a new release"
5) Under "Choose a tag" enter the new version number 
6) Click "Create new tag: {version} on publish"
7) Verify the "Target" is set to "main"
8) Enter a title and description of the release if so desired
9) Click the green "Publish release" button

## TODO List
Attachable Googly Eyes
PHRED Flag
PHRED FRC Bot Entities
PHRED FTC Bot Entities

## Other background
The minecraft-mod is set up with the following manual configuration to allow for auto-deployment
1) The PHRED AWS account has a single EC2 instance that was set up by hand.  This is a pretty standard Debian instance, with just the necessary Java SDK installed.
2) There is a "PHRED Minecraft Server" environment in https://github.com/PHREDRobotics/minecraft-mod/settings/environments that gives the location and credentials for the minecraft server in AWS.
3) The server was set up using the instructions from https://minecraft.fandom.com/wiki/Tutorials/Server_startup_script, with the service script managed as part of this repo.
4) The server is set up with the phred server as its on folder under /opt/minecraft.  If the server file structure needs to change, make sure the minecraft-server-deploy.sh is updated to match
5) The ops.json and server.properties are only minimally change from defaults.  Any "superusers" should be added to the ops.json, and any important properties in server.properties should be changed in the repo and deployed, not directly on the server
