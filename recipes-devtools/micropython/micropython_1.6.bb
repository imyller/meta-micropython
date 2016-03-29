DESCRIPTION = "MicroPython is a lean and fast implementation of the Python 3 programming language"
HOMEPAGE = "https://micropython.org"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a8a14efdd86622bc2a34296228779da7"

inherit autotools-brokensep

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " \
	https://github.com/micropython/micropython/archive/v${PV}.tar.gz;name=src \
"

SRC_URI[src.md5sum] = "e5c53c2c19bb454d0854b2ed8896e43c"
SRC_URI[src.sha256sum] = "f8ea3faffa797de1a06c16c8f57c784c665b318ca08ac17f74dcbc95322d47de"

DEPENDS = "libffi"

EXTRA_OEMAKE = " \
	-C ${S}/unix \
	MICROPY_USE_READLINE=0 \
	V=1 \
	DESTDIR="${D}" \
	CC="${CC}" \
	LD="${LD}" \
	CROSS_COMPILE="${TARGET_PREFIX}" \
	PREFIX="${D}/usr" \
"

do_compile() {
	oe_runmake micropython
}

do_configure() {
	:
}

RRECOMMENDS_${PN} = "micropython-lib"

INSANE_SKIP_${PN} = "already-stripped"

BBCLASSEXTEND = "native"

