#
# SPDX-License-Identifier: MPL-2.0
#
# Copyright (C) 2026 Luca Carlon
#
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at https://mozilla.org/MPL/2.0/.
#

do_install:append() {
    # Remove kernel warnings.
    sed -i 's/^net.ipv4.conf.all.log_martians\s*=\s*1$/net.ipv4.conf.all.log_martians = 0/' ${D}/etc/sysctl.conf
    sed -i 's/^#\(kernel.printk = 3 4 1 3\)/\1/' ${D}/etc/sysctl.conf
}
