#!/bin/bash

export $(grep -v '^#' .env | xargs)
./mvnw install

if [ $? -ne 0 ] ; then
    echo "Build failed!"
    exit 1
fi

mkdir -p target/dependency
(cd target/dependency; jar -xf ../*.jar)

podman-compose down
podman image rm localhost/taskman-rest-spring_app
podman-compose up --build --detach