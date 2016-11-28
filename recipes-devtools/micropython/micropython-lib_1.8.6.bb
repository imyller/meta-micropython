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

SRC_URI[src.md5sum] = "e0b313e7d6378f52607844fd30d79630"
SRC_URI[src.sha256sum] = "eb696009ff8c33004211e484649b34edb14f3efb2ff618942bc8888716757a55"

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
	cp -r --preserve=mode,links ${B}/* ${D}${libdir}/micropython/
}

FILES_${PN} = " \
	${libdir}/micropython/* \
"

BBCLASSEXTEND = "native"
