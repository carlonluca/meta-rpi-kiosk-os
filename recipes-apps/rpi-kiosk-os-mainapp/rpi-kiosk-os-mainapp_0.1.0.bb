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
SRCREV = "74b3deebc5b78a5c0cf23313e44a181c1ed46e35"
SRC_URI = "git://github.com/carlonluca/rpi-kiosk-os-mainapp.git;branch=master;protocol=https"
S = "${WORKDIR}/git"

inherit qt6-cmake
