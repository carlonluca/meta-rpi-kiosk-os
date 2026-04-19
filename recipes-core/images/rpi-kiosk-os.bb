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

SYSTEMD_DEFAULT_TARGET = "graphical.target"
DISTRO_FEATURES:append = " systemd"