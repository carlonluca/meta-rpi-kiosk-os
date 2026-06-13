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

RDEPENDS:${PN}:remove = "systemd-serialgetty"

do_install:append() {
    # Disable getty@ttyS0 from starting at boot time.
    sed -i -e "s/enable getty@.service/disable getty@.service/g" ${D}${systemd_unitdir}/system-preset/90-systemd.preset
    rm -f ${D}${systemd_system_unitdir}/serial-getty@.service
}
