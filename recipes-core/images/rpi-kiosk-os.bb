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
inherit populate_sdk populate_sdk_qt6

SYSTEMD_DEFAULT_TARGET = "graphical.target"

EXTRA_IMAGE_FEATURES += "debug-tweaks"
#DEV_TOOLS = "${@bb.utils.contains('EXTRA_IMAGE_FEATURES', 'debug-tweaks', " \
#   qtdeclarative-tools \
#   packagegroup-qt6-essentials \
#   packagegroup-qt6-addons \
#   packagegroup-core-full-cmdline \
#", '', d)}"
FULL_QT += "qtdeclarative-tools packagegroup-qt6-essentials packagegroup-qt6-addons packagegroup-core-full-cmdline"
IMAGE_INSTALL:append = " \
   rpi-kiosk-os-mainapp \
   mesa mesa libgl-mesa-dev libgles3-mesa-dev \
   ${FULL_QT} \
"
IMAGE_INSTALL:remove = "busybox"

IMAGE_FEATURES += "ssh-server-openssh"

RPI_EXTRA_CONFIG = " \n \
   gpu_mem=256 \n \
   disable_overscan=1 \n \
   dtoverlay=vc4-kms-v3d \n \
   max_framebuffers=2 \n \
"
