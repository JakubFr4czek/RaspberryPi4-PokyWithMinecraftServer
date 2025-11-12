#!/bin/bash

docker build -t yocto-ubuntu . && docker run -it --rm -v $(pwd):/var/yocto --workdir /var/yocto yocto-ubuntu bash -c "./build.sh"