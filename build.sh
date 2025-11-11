#!/bin/bash

sudo apt-get update
sudo apt-get install build-essential chrpath cpio debianutils diffstat file gawk gcc git iputils-ping libacl1 \
     liblz4-tool locales python3 python3-git python3-jinja2 python3-pexpect python3-pip python3-subunit socat \
     texinfo unzip wget xz-utils zstd -y

git clone https://git.yoctoproject.org/poky -b scarthgap
cd poky
git clone git://git.yoctoproject.org/meta-raspberrypi -b scarthgap
git clone https://git.openembedded.org/meta-openembedded -b scarthgap

source oe-init-build-env my_rpi_build

rm -rf conf/bblayers.conf
rm -rf conf/local.conf

ln -s /home/fraczek/dev/raspberry_pi_custom_distro/files/bblayers.conf conf/bblayers.conf
ln -s /home/fraczek/dev/raspberry_pi_custom_distro/files/local.conf conf/local.conf

ln -s /home/fraczek/dev/raspberry_pi_custom_distro/meta-my-layer ../.
ln -s /home/fraczek/dev/raspberry_pi_custom_distro/meta-minecraft ../.

bitbake core-image-full-cmdline