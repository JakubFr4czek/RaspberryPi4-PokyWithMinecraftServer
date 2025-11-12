#!/bin/bash

sudo docker run -v $(pwd):/var/yocto --rm --workdir /var/yocto --name yoctobuilder ubuntu:22.04 bash -c "./build.sh"