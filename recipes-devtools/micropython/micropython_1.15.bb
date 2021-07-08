DESCRIPTION = "MicroPython is a lean and fast implementation of the Python 3 programming language"
HOMEPAGE = "https://micropython.org"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d13714d609dce89ca5832f2e0864344"

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " \
	gitsm://github.com/micropython/micropython.git;name=src;tag=v${PV} \
        file://001-force-python3.patch \
"

S = "${WORKDIR}/git"

DEPENDS = "libffi python3-native"

inherit autotools-brokensep

EXTRA_OEMAKE = " \
	MICROPY_USE_READLINE=0 \
	V=1 \
	DESTDIR="${D}" \
	CC="${CC}" \
	LD="${LD}" \
	CROSS_COMPILE="${TARGET_PREFIX}" \
        CWARN=" -Wno-error" \
	PREFIX="${D}/usr" \
        PYTHON="python3" \
"

do_compile() {
	make -C ${S}/mpy-cross
	oe_runmake -C ${S}/ports/unix submodules
	oe_runmake -C ${S}/ports/unix
}

do_configure() {
	:
}

do_install() {
        install -d ${D}${bindir}/
        cp -r --preserve=mode,links ${B}/ports/unix/micropython ${D}${bindir}/
}

FILES_${PN} = " \
        ${bindir}/micropython \
"


RRECOMMENDS_${PN} = "micropython-lib"

INSANE_SKIP_${PN} = "already-stripped ldflags"
