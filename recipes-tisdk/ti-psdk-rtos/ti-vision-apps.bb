SUMMARY = "OpenVX Middleware library"
DESCRIPTION = "Builds tivision_apps user space library"

PR:append = "_edgeai_7"

PV = "10.0.0"

LICENSE = "TI-TFL & BSD-2-Clause & BSD-3-Clause & BSD-4-Clause & MIT & Apache-2.0 & Apache-2.0-with-LLVM-exception & \
           Khronos & Hewlett-Packard & Patrick-Powell & FTL & Zlib & CC0-1.0 & OpenSSL"

LIC_FILES_CHKSUM = "file://${COREBASE}/../meta-ti/meta-ti-bsp/licenses/TI-TFL;md5=a1b59cb7ba626b9dbbcbf00f3fbc438a \
                    file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f \
                    file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                    file://${COMMON_LICENSE_DIR}/BSD-4-Clause;md5=624d9e67e8ac41a78f6b6c2c55a83a2b \
                    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0-with-LLVM-exception;md5=0bcd48c3bdfef0c9d9fd17726e4b7dab \
                    file://repo/tiovx/include/VX/vx.h;beginline=1;endline=15;md5=37315206223081f32a5b9aaaf912f637 \
                    file://${COREBASE}/../meta-ti/meta-ti-extras/licenses/Hewlett-Packard;md5=a07676ee09f5bfec457eb5ea75921d01 \
                    file://${COREBASE}/../meta-ti/meta-ti-extras/licenses/Patrick-Powell;md5=7e10716f13cff502f3cf6ebf8fe29c1e \
                    file://${COMMON_LICENSE_DIR}/FTL;md5=f0bf6b09ee8b02121ed10709d9e49d8b \
                    file://${COMMON_LICENSE_DIR}/Zlib;md5=87f239f408daca8a157858e192597633 \
                    file://${COMMON_LICENSE_DIR}/CC0-1.0;md5=0ceb3372c9595f0a8067e55da801e4a1 \
                    file://${COREBASE}/meta/files/common-licenses/OpenSSL;md5=4eb1764f3e65fafa1a25057f9082f2ae \
                    "

SRCREV_FORMAT="default"
SRCREV_sdk_builder = "7e104e54870c8bc751ed74873ada8519f4fba73f"
SRCREV_app_utils = "07816742bf0c4cd372c19eeebde64ed9499ac826"
SRCREV_vision_apps = "8b1b730370f5ca028f31d2521408920f5536b57b"
SRCREV_tiovx = "370e9661a318c5fdce8e05835252433ca3daf17a"
SRCREV_imaging = "0f199b4d6d6cf0212fae88f24e764ebb6df73fca"
SRCREV_video_io = "108ae96788c3f97768c434d011269518532d2b3b"
SRCREV_ti-perception-toolkit = "8d090941dd671a5e670aa8f777986be73763ab41"
SRCREV_psdk_include = "2dde83677ad4daf0d3e53bcd6d2a032a9bac53aa"
SRCREV_arm-tidl = "d71785f6619bcc07f2fc6ed59cefe1de8fb18288"
SRCREV_concerto = "38b9190a5d335e58d81d21e3e058b11e5c47c605"
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
file://0001-makefile_linux_arm-replace-usr-lib-with-variable-lib.patch;patchdir=repo/sdk_builder \
"

#PTK needs:
# EGL/egl.h
# glm/glm.hpp
# IL/il.h
# /usr/include/freetype2/ft2build.h
# ti_rpmsg_char.h
# dlr.h

DEPENDS = "glm devil freetype ti-rpmsg-char repo-native mesa-pvr libpam"
DEPENDS:remove:am62axx = " mesa-pvr"

COMPATIBLE_MACHINE = "j721e|j721s2|j784s4|j722s|am62axx"

PLAT_SOC = ""
PLAT_SOC:j721e = "j721e"
PLAT_SOC:j721s2 = "j721s2"
PLAT_SOC:j784s4 = "j784s4"
PLAT_SOC:j722s = "j722s"
PLAT_SOC:am62axx = "am62a"

S = "${WORKDIR}"

EXTRA_OEMAKE += "-C ${S}/repo/sdk_builder"

do_fetch[depends] += "repo-native:do_populate_sysroot"

do_compile() {
    CROSS_COMPILE_LINARO=aarch64-wrs-linux- \
    LINUX_SYSROOT_ARM=${STAGING_DIR_TARGET} \
    TREAT_WARNINGS_AS_ERROR=0 \
    GCC_LINUX_ARM_ROOT= \
    GCC_LINUX_ARM_ROOT_A72= \
    LINUX_FS_PATH=${STAGING_DIR_TARGET} \
    SOC=${PLAT_SOC} \
    oe_runmake yocto_build
}

do_install() {
    SOC=${PLAT_SOC} LINUX_FS_STAGE_PATH=${D} oe_runmake yocto_install
}

INSANE_SKIP:${PN} += "ldflags"
