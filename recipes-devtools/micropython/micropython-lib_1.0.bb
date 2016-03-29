DESCRIPTION = "Core Python libraries ported to MicroPython"
HOMEPAGE = "https://github.com/micropython/micropython-lib"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b4c9cf84e44b0961b744ae0ca6617ae6"

inherit autotools

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " \
	https://github.com/micropython/micropython-lib/archive/v${PV}.tar.gz;name=src \
"

SRC_URI[src.md5sum] = "d4092764630314609ef2a4d2d9d26d14"
SRC_URI[src.sha256sum] = "e659444fadd755c1b5dbff091aa1b23a835e7361da3a32f38774bd39a15937ad"

RDEPENDS_${PN} = "micropython"
RDEPENDS_${PN}-native = "micropython-native"

do_compile() {
	:
}

do_configure() {
	:
}

do_install() {
	oe_runmake -C ${S} PREFIX=${B} install	
	install -d ${D}${libdir}/micropython
	cp -r ${B}/* ${D}${libdir}/micropython/
}

FILES_${PN} = " \
	${libdir}/micropython/* \
"

BBCLASSEXTEND = "native"
