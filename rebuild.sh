#!/bin/bash
cd poky

source oe-init-build-env my_rpi_build

bitbake core-image-full-cmdline