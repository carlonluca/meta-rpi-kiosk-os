#
# SPDX-License-Identifier: MPL-2.0
#
# Copyright (C) 2026 Luca Carlon
#
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at https://mozilla.org/MPL/2.0/.
#

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://config.txt"

do_deploy:append() {
    install -d "${DEPLOYDIR}/${BOOTFILES_DIR_NAME}"
    install -m 0644 ${WORKDIR}/sources/config.txt ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}
}

FILES:${PN} += "${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt"
