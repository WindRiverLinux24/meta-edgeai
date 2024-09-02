SUMMARY = "TI GPIO cpp"
DESCRIPTION = "A Linux based CPP library for TI GPIO RPi header enabled platforms"
HOMEPAGE = "https://github.com/TexasInstruments/ti-gpio-cpp"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE.txt;md5=4a6102d7daa29b70c1abe088c13a0cde"

SRC_URI = "git://github.com/TexasInstruments/ti-gpio-cpp.git;protocol=https;branch=master \
file://0001-ti-gpio-cpp-cmake-remove-the-CMAKE_INSTALL_LIBDIR-se.patch"
SRCREV = "982c761ec428a0d2c81d63d2986323fbc38d88db"

S = "${WORKDIR}/git"

DEPENDS = "libgpiod"
COMPATIBLE_MACHINE = "j721e|j721s2|j784s4|j722s|am62axx|am62pxx"

EXTRA_OECMAKE = "-DCMAKE_SKIP_RPATH=TRUE"

PACKAGES += "${PN}-source"
FILES:${PN}-source += "/opt/"

inherit cmake

do_install:append() {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"

    mkdir -p ${D}/opt/ti-gpio-cpp
    cp ${CP_ARGS} ${S}/* ${D}/opt/ti-gpio-cpp
    rm -rf ${D}/opt/ti-gpio-cpp/lib
    rm -rf ${D}/usr/cmake
}

PR:append = "_edgeai_2"
