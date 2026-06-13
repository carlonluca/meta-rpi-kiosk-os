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

RDEPENDS:${PN} += " bash"

SRC_URI += " \
    file://fstab \
    file://kioskui_start \
    file://kioskui_stop \
    file://kioskui_restart \
    file://remount_ro \
    file://remount_rw \
    file://reboot \
    file://99-kioskui.rules \
"

do_install:append() {
    mkdir -p ${D}/boot_rpi
    mkdir -p ${D}/boot
    mkdir -p ${D}/var/log
    mkdir -p ${D}/var/tmp
    mkdir -p ${D}/var/lib/dhcp
    mkdir -p ${D}/var/run
    mkdir -p ${D}/var/spool

    install -m 0644 ${WORKDIR}/fstab ${D}${sysconfdir}/
    install -m 0755 ${WORKDIR}/kioskui_start ${D}${bindir}
    install -m 0755 ${WORKDIR}/kioskui_stop ${D}${bindir}
    install -m 0755 ${WORKDIR}/kioskui_restart ${D}${bindir}
    install -m 0755 ${WORKDIR}/remount_ro ${D}${bindir}
    install -m 0755 ${WORKDIR}/remount_rw ${D}${bindir}
    install -m 0755 ${WORKDIR}/reboot ${D}${bindir}

    install -d ${D}/${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/99-kioskui.rules ${D}${sysconfdir}/udev/rules.d/

    # lcarlon: for the at service
    mkdir -p ${D}/var/spool/at/jobs
}

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-kioskui.rules"
FILES:${PN} += "${sysconfdir}/fstab"
FILES:${PN} += "${bindir}/kioskui_start"
FILES:${PN} += "${bindir}/kioskui_stop"
FILES:${PN} += "${bindir}/kioskui_restart"
FILES:${PN} += "${bindir}/remount_ro"
FILES:${PN} += "${bindir}/remount_rw"
FILES:${PN} += "${bindir}/reboot"
