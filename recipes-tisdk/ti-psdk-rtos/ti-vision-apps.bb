SUMMARY = "OpenVX Middleware library"
DESCRIPTION = "Builds tivision_apps user space library"

PR:append = "_edgeai_13"

PV = "11.00.00"

LICENSE = "TI-TFL & BSD-2-Clause & BSD-3-Clause & BSD-4-Clause & MIT & Apache-2.0 & Apache-2.0-with-LLVM-exception & \
           Khronos & Hewlett-Packard & Patrick-Powell & FTL & Zlib & CC0-1.0 & OpenSSL"

LIC_FILES_CHKSUM = "file://${COREBASE}/../meta-ti/meta-ti-bsp/licenses/TI-TFL;md5=a1b59cb7ba626b9dbbcbf00f3fbc438a \
                    file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f \
                    file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                    file://${COMMON_LICENSE_DIR}/BSD-4-Clause;md5=624d9e67e8ac41a78f6b6c2c55a83a2b \
                    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0-with-LLVM-exception;md5=0bcd48c3bdfef0c9d9fd17726e4b7dab \
                    file://${WORKDIR}/repo/tiovx/include/VX/vx.h;beginline=1;endline=15;md5=37315206223081f32a5b9aaaf912f637 \
                    file://${COREBASE}/../meta-ti/meta-ti-extras/licenses/Hewlett-Packard;md5=a07676ee09f5bfec457eb5ea75921d01 \
                    file://${COREBASE}/../meta-ti/meta-ti-extras/licenses/Patrick-Powell;md5=7e10716f13cff502f3cf6ebf8fe29c1e \
                    file://${COMMON_LICENSE_DIR}/FTL;md5=f0bf6b09ee8b02121ed10709d9e49d8b \
                    file://${COMMON_LICENSE_DIR}/Zlib;md5=87f239f408daca8a157858e192597633 \
                    file://${COMMON_LICENSE_DIR}/CC0-1.0;md5=0ceb3372c9595f0a8067e55da801e4a1 \
                    file://${COREBASE}/meta/files/common-licenses/OpenSSL;md5=4eb1764f3e65fafa1a25057f9082f2ae \
                    "

SRCREV_FORMAT="default"
SRCREV_sdk_builder = "e21501bb0b9ff0922cb64b6e5a303a82266d28f7"
SRCREV_app_utils = "04355e7112f66093a56cacdb109faa317b148c02"
SRCREV_vision_apps = "c500b3ee4db9a040aae99ddc8d8c709a1275cbe5"
SRCREV_tiovx = "cbcf513ac89fa53700a9055c1296b844d9ee3bd4"
SRCREV_imaging = "d2a3565032e362df67a82f692a6d72d5b9b4638b"
SRCREV_video_io = "c75d8585e6a184131cdf6c927c8f0bacb517885a"
SRCREV_ti-perception-toolkit = "7074d1c78e28082c657b77bf2ed5dc40525146c0"
SRCREV_psdk_include = "2dde83677ad4daf0d3e53bcd6d2a032a9bac53aa"
SRCREV_arm-tidl = "38a2f55ed3b8b11e1e25359f724b75320f26f003"
SRCREV_concerto = "707b11afdbe5d0abb109a42b06828ba70f555bff"
TI_BRANCH = "main"
FILES:${PN} += "/opt/* \
                /usr/lib64/* \
"

SRC_URI = " \
git://git.ti.com/git/processor-sdk/sdk_builder.git;protocol=https;branch=${TI_BRANCH};branch=${TI_BRANCH};name=sdk_builder;destsuffix=repo/sdk_builder \
git://git.ti.com/git/processor-sdk/app_utils.git;protocol=https;branch=${TI_BRANCH};name=app_utils;destsuffix=repo/app_utils \
git://git.ti.com/git/processor-sdk/vision_apps.git;protocol=https;branch=${TI_BRANCH};name=vision_apps;destsuffix=repo/vision_apps \
git://git.ti.com/git/processor-sdk/tiovx.git;protocol=https;branch=${TI_BRANCH};name=tiovx;destsuffix=repo/tiovx \
git://git.ti.com/git/processor-sdk/imaging.git;protocol=https;branch=${TI_BRANCH};name=imaging;destsuffix=repo/imaging \
git://git.ti.com/git/processor-sdk/video_io.git;protocol=https;branch=${TI_BRANCH};name=video_io;destsuffix=repo/video_io \
git://git.ti.com/git/processor-sdk/ti-perception-toolkit.git;protocol=https;branch=${TI_BRANCH};name=ti-perception-toolkit;destsuffix=repo/ti-perception-toolkit \
git://git.ti.com/git/processor-sdk/psdk_include.git;protocol=https;branch=${TI_BRANCH};name=psdk_include;destsuffix=repo/psdk_include \
git://git.ti.com/git/processor-sdk-vision/arm-tidl.git;protocol=https;branch=master;name=arm-tidl;destsuffix=repo/psdk_include/tidl_j7/arm-tidl \
git://git.ti.com/git/processor-sdk/concerto.git;protocol=https;branch=${TI_BRANCH};name=concerto;destsuffix=repo/sdk_builder/concerto \
file://0001-makefile_linux_arm-replace-usr-lib-with-variable-lib.patch \
"

#PTK needs:
# EGL/egl.h
# glm/glm.hpp
# IL/il.h
# /usr/include/freetype2/ft2build.h
# ti_rpmsg_char.h
# dlr.h

DEPENDS = "glm freetype ti-rpmsg-char repo-native virtual/egl libpam"

COMPATIBLE_MACHINE = "j721e|j721s2|j784s4|j722s|j742s2|am62axx"

PLAT_SOC = ""
PLAT_SOC:j721e = "j721e"
PLAT_SOC:j721s2 = "j721s2"
PLAT_SOC:j784s4 = "j784s4"
PLAT_SOC:j722s = "j722s"
PLAT_SOC:j742s2 = "j742s2"
PLAT_SOC:am62axx = "am62a"

S = "${WORKDIR}/repo/sdk_builder"

do_fetch[depends] += "repo-native:do_populate_sysroot"

CLEANBROKEN = "1"

do_compile() {
    export CROSS_COMPILE_LINARO=aarch64-wrs-linux- \
    LINUX_SYSROOT_ARM=${STAGING_DIR_TARGET} \
    TREAT_WARNINGS_AS_ERROR=0 \
    GCC_LINUX_ARM_ROOT= \
    GCC_LINUX_ARM_ROOT_A72= \
    LINUX_FS_PATH=${STAGING_DIR_TARGET} \
    SOC=${PLAT_SOC}
    oe_runmake yocto_build
}

do_install() {
    export SOC=${PLAT_SOC} LINUX_FS_STAGE_PATH=${D}
    oe_runmake yocto_install
}

INSANE_SKIP:${PN} += "ldflags buildpaths"
