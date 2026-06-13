#
# SPDX-License-Identifier: MPL-2.0
#
# Copyright (C) 2026 Luca Carlon
#
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at https://mozilla.org/MPL/2.0/.
#

SUMMARY = "rpi-kiosk-os"

include recipes-core/images/core-image-base.bb
#inherit populate_sdk populate_sdk_qt6

IMAGE_FEATURES:append = " read-only-rootfs allow-root-login ssh-server-openssh"
IMAGE_FEATURES:remove = "3g bluetooth irda nfc zeroconf x11 wayland bluez5"

IMAGE_INSTALL:remove = "ofono"
IMAGE_INSTALL:append = " \
   rpi-kiosk-os-mainapp \
   mesa libgl-mesa-dev libgles3-mesa-dev \
   packagegroup-qt6-essentials \
   packagegroup-qt6-addons \
   packagegroup-core-full-cmdline \
   packagegroup-rpi-kiosk-os-base \
   dbus alsa-lib alsa-utils alsa-tools \
"

IMAGE_INSTALL:append = " gstreamer1.0  gstreamer1.0-meta-base gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-ugly"
IMAGE_INSTALL:remove = "agetty systemd-serialgetty"

TOOLCHAIN_TARGET_TASK += " mesa libgl-mesa-dev libgles3-mesa-dev"

inherit extrausers
PASSWD = "\$5\$kBUWFioTofF6UcbO\$mt8/e5p5cx1z88e61gsSYu1DhFac7lglhUm6.CfIRA5"
EXTRA_USERS_PARAMS = " \
    usermod -p '${PASSWD}' root; \
    usermod -s /bin/bash root; \
    usermod -d /root -m root; \
"
