# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://minecraft_server.jar;unpack=0 file://minecraft-server.service"

# NOTE: no Makefile found, unable to determine what needs to be done

inherit allarch systemd
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "minecraft-server.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install () {
	install -d ${D}/var/minecraft/server
	install -m 0755 ${WORKDIR}/minecraft_server.jar ${D}/var/minecraft/server

	install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/minecraft-server.service ${D}${systemd_system_unitdir}

	bbwarn "minecraft-server.service installed"
	bbwarn ${D}${systemd_system_unitdir}
}

FILES:${PN} += "/var/minecraft"
FILES:${PN} += "${systemd_system_unitdir}/minecraft-server.service"

