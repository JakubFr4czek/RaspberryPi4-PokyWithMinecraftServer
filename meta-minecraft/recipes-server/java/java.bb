LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "https://download.oracle.com/java/25/latest/jdk-25_linux-aarch64_bin.tar.gz"
SRC_URI[sha256sum] = "cbf0fd6678a66d7534d37966bc8b9aa177ca8f091800ab7e8c2f87cf6ccb693f"

RDEPENDS:${PN} += "zlib alsa-lib freetype libx11 libxext libxi libxrender libxtst"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install () {
    
    #tar zxvf ${WORKDIR}/jdk-25_linux-aarch64_bin.tar.gz --no-same-owner -C ${D}/usr/java

    install -d ${D}/usr/lib/java
    install -d ${D}/usr/bin

    cp -r ${WORKDIR}/jdk-25.0.1 ${D}/usr/lib/java
    ln -s ../lib/java/jdk-25.0.1/bin/java ${D}/usr/bin/java # Symlink is relative to the ${D}/usr/bin/java location
}

FILES:${PN} += "/usr/lib/java"
FILES:${PN} += "/usr/bin/java"

