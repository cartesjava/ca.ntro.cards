#! /usr/bin/python3
# vim: set fileencoding=utf-8 :
#
# --
# Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
# --
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU AFFERO General Public License as published by
# the Free Software Foundation; either version 3 of the License, or
# any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
# or see http://www.gnu.org/licenses/agpl.txt.
# --

from __future__ import print_function

import os
import argparse
import codecs

parser = argparse.ArgumentParser(description='Adds license notices to source files')
parser.add_argument('-txt', metavar='TXT', type=str, help='License notice text')
parser.add_argument('-dir', metavar='DIR', type=str, help='Root dir of source files')

args = parser.parse_args()

if args.txt is None or args.dir is None:
    parser.print_usage()
    exit(0)

TXT_PATH = args.txt
DIR_PATH = args.dir

def write_license(fileext, filepath, license_text):
    filecontent = ""
    with codecs.open(filepath, encoding='utf-8') as _file:
        filecontent = _file.read()

    with codecs.open(filepath, 'w', encoding='utf-8') as _file:
        if fileext == '.java':
            _file.write('/*\n')

        for license_line in license_text.split('\n'):
            _file.write(license_line)
            _file.write('\n')

        if fileext == '.java':
            _file.write('*/\n')

        _file.write(filecontent)

with codecs.open(TXT_PATH, encoding="utf-8") as txt_file:

    license_text = txt_file.read()

    for dirpath, dirs, files in os.walk(DIR_PATH):
        for filename in files:
            basename, ext = os.path.splitext(filename)
            if ext == '.java':
                filepath = os.path.join(dirpath, filename)
                print(filepath)
                write_license(ext, filepath, license_text)

