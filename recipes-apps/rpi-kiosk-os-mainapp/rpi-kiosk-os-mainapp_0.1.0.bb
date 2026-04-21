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
   userland \
   qttools \
   qtbase \
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
SRCREV = "2d2c07b192340d1d4c61d1d2a3727457c2f2a3e2"
SRC_URI = "git://github.com/carlonluca/rpi-kiosk-os-mainapp.git;branch=master;protocol=https"
S = "${WORKDIR}/git"
BIN_DIR = "${D}${bindir}"

inherit qt6-cmake

do_install () {
   install -m 0755 ${B}/appRpiKioskOsMainApp ${BIN_DIR}
}