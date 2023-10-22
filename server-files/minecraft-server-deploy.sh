#!/bin/bash

set -e

MINECRAFT_PATH=/opt/minecraft
SERVERNAME=phred
SERVER_PATH=$MINECRAFT_PATH/$SERVERNAME
TIMESTAMP="$(date +"%T")"
TMP_PATH=/tmp/minecraft

#Stop the server
sudo systemctl stop minecraft@$SERVERNAME

#Backup the files
BACKUP_PATH=$MINECRAFT_PATH/backups/$SERVERNAME/$TIMESTAMP
mkdir -p $BACKUP_PATH
cp /etc/systemd/system/minecraft@.service $BACKUP_PATH/minecraft@.service
cp $SERVER_PATH/ops.json $BACKUP_PATH/ops.json
cp $SERVER_PATH/server.properties $BACKUP_PATH/server.properties
mv $SERVER_PATH/mods/fabric-phred-mod*.jar $BACKUP_PATH/

#Move files from new release
mv $TMP_PATH/minecraft@.service /etc/systemd/system/minecraft@.service
mv $TMP_PATH/ops.json $SERVER_PATH/ops.json
mv $TMP_PATH/server.properties $SERVER_PATH/server.properties
mv $TMP_PATH/fabric-phred-mod*.jar $SERVER_PATH/mods/

#Start the server
sudo systemctl start minecraft@$SERVERNAME


