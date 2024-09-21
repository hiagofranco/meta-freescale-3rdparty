SUMMARY = "U-Boot bootloader with support for Toradex iMX6/iMX7/iMX8MM Computer on Modules"
HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += " \
    bc-native \
    dtc-native \
    gnutls-native \
    python3-jsonschema-native \
    python3-pyelftools-native \
    python3-pyyaml-native \
    python3-yamllint-native \
    "
PROVIDES += "u-boot"
PV = "2024.07+git${SRCPV}"

SRC_URI = " \
    git://source.denx.de/u-boot/u-boot.git;protocol=https;branch=master \
    file://0001-board-toradex-verdin-imx8mm-add-4-GB-lpddr4-memory-s.patch \
    file://0002-board-toradex-verdin-imx8mm-increase-maximum-address.patch \
    file://0003-toradex-tdx-cfg-block-add-aquila-am69-sku-0088-pid4.patch \
    file://0004-toradex-tdx-cfg-block-add-verdin-imx95-sku-0089-pid4.patch \
    file://0005-toradex-tdx-cfg-block-add-verdin-i.mx8m-mini-0090-pi.patch \
    file://0006-ARM-imx-verdin-imx8mm-Set-CAN-oscillator-frequency-b.patch \
    file://0001-configs-verdin-imx8m-mp-set-CONFIG_SPL_LOAD_FIT_ADDR.patch \
    "
SRCREV = "3f772959501c99fbe5aa0b22a36efe3478d1ae1c"
S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

PACKAGE_ARCH = "${MACHINE_ARCH}"
UBOOT_INITIAL_ENV = "u-boot-initial-env"
