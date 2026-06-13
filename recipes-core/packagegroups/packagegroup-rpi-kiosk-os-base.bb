#
# SPDX-License-Identifier: MPL-2.0
#
# Copyright (C) 2026 Luca Carlon
#
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at https://mozilla.org/MPL/2.0/.
#

DESCRIPTION = "Base tools for rpi-kiosk-os image"
LICENSE = "MPL-2.0"
SUMMARY = "Base tools for rpi-kiosk-os image"

inherit packagegroup

RDEPENDS:${PN} += " \
    nano \
    htop \
    iotop \
    bash \
    file \
    ttf-roboto \
    ffmpeg \
    omxplayer \
    net-tools \
    gptfdisk \
    e2fsprogs \
    iputils \
    cgrc \
    util-linux \
    curl \
    sysstat \
    module-init-tools \
    tzdata \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-misc \
    v4l-utils \
"
