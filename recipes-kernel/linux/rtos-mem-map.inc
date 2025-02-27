FILESEXTRAPATHS:prepend := "${THISDIR}/linux-ti-staging/:${THISDIR}/linux-ti-staging/${MACHINE}:"

SRC_URI:append:edgeai = " \
    file://0001-arm64-Enable-docker-support-in-defconfig.patch \
"

SRC_URI:append = " \
    file://0001-remoteproc-k3-dsp-assert-reset-in-probe.patch \
"

SRC_URI:append:j721e = " \
    file://0001-arm64-dts-ti-Add-DTB-overlays-for-vision-apps-and-ed.patch \
"

SRC_URI:append:j721s2 = " \
    file://0001-arm64-dts-ti-Add-DTB-overlay-for-vision-apps.patch \
    file://0002-arm64-dts-ti-k3-j721s2-Add-overlay-for-edge-ai.patch \
"

SRC_URI:append:j784s4 = " \
    file://0001-arm64-dts-ti-Add-DTB-overlay-for-vision-apps.patch \
    file://0002-arm64-dts-ti-k3-j784s4-Add-overlay-for-edge-ai.patch \
"

SRC_URI:append:j722s = " \
    file://0001-arm64-dts-ti-j722s-Add-DTB-overlay-for-RTOS-memory-m.patch \
"

PR:append = "_edgeai_8"
