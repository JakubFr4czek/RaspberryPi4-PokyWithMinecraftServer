# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#   lang/LICENSE.it.txt
#   lang/LICENSE.pt_br.txt
#   lang/LICENSE.ru.txt
#   runtime/pack/dist/opt/editorconfig/LICENSE
#   runtime/pack/dist/opt/editorconfig/LICENSE.PSF
#   runtime/pack/dist/opt/netrw/LICENSE.txt
#   src/xdiff/COPYING
#   src/xpm/COPYRIGHT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT & Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1a651ab770b45d41c0f8cb5a8ca930e \
                    file://lang/LICENSE.it.txt;md5=875a005bc3e3192ee35ac6165bd71697 \
                    file://lang/LICENSE.pt_br.txt;md5=bedd4e5c4a8c69457a34adf62ea1ff3e \
                    file://lang/LICENSE.ru.txt;md5=251786c79f67704251fa8760db540de9 \
                    file://runtime/pack/dist/opt/editorconfig/LICENSE;md5=307d2e3ed9b0e39a1ad9a9d139f6b777 \
                    file://runtime/pack/dist/opt/editorconfig/LICENSE.PSF;md5=806566ce525c75712a977d5c300c3e5d \
                    file://runtime/pack/dist/opt/netrw/LICENSE.txt;md5=304b146ceeb7e7c5a47caaa57b2c6f6e \
                    file://src/libvterm/LICENSE;md5=be5681ffe0dc58ccc9756bc6260fe0cd \
                    file://src/xdiff/COPYING;md5=278f2557e3b277b94e9a8430f6a6d0a9 \
                    file://src/xpm/COPYRIGHT;md5=1e8b098093f3bb7a8fed64938e8e465e"

SRC_URI = "git://git@github.com/vim/vim.git;protocol=ssh;branch=master"

# Modify these as desired
PV = "1.0+git"
SRCREV = "cf4d9625c6eb21107e030dc879c1390596fbdb8d"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

DEPENDS += "ncurses"
INSANE_SKIP:${PN} += "already-stripped"

do_configure() {
    cd ${S}
    ./configure --prefix=/usr \
                --with-features=small \
                --disable-gui \
                --without-x \
                --enable-multibyte \
                --with-tlib=ncurses \
                --host=${TARGET_SYS}
}


do_compile () {
    cd ${S}
	make
}

do_install () {
    cd ${S}
	make install DESTDIR=${D} prefix=/usr vimrcdir=/etc/vim
    rm -rf ${D}/usr/share/icons
}

