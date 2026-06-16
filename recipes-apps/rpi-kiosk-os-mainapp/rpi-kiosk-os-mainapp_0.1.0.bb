#
# SPDX-License-Identifier: MPL-2.0
#
# Copyright (C) 2026 Luca Carlon
#
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at https://mozilla.org/MPL/2.0/.
#

SUMMARY = "MainApp"
DESCRIPTION = "Main OS app running a webapp"
DEPENDS += " \
   qtbase \
   qtdeclarative \
   qtdeclarative-native \
   userland \
   qtwebengine \
   qtdeclarative \
"
RDEPENDS:${PN} = " \
   userland \
   qtbase \
   qtwebengine \
   qtdeclarative \
"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f75d2927d3c1ed2414ef72048f5ad640"
SRCREV = "00a6c5dd7648e1c3272610c2cd2068b24f43311c"
SRC_URI = " \
   git://github.com/carlonluca/rpi-kiosk-os-mainapp.git;branch=master;protocol=https \
   file://rpi-kiosk-os-mainapp.service \
"
S = "${WORKDIR}/git"
SBIN_DIR = "${D}${sbindir}"

inherit qt6-cmake

do_install:append () {
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/rpi-kiosk-os-mainapp.service ${D}/${systemd_unitdir}/system
}

FILES:${PN} += "${systemd_unitdir}/system/rpi-kiosk-os-mainapp.service"
FILES:${PN} += "${bindir}/appRpiKioskOsMainApp"

inherit systemd
SYSTEMD_PACKAGES = "${PN}"
NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "rpi-kiosk-os-mainapp.service"
