# Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
#
# This file is part of Ntro
#
# Ntro is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# Ntro is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

##### INCLUDE #####
this_dir=$(readlink -f "$0")
scripts_dir=$(dirname "$this_dir")
. "$scripts_dir/include.sh"
###################

atelier="mise_a_jour_atelier1_2"

save_dir

cd "$root_dir"

zip -r "$atelier.zip" atelier1_2_1/build.gradle
zip -r "$atelier.zip" atelier1_2_1/atelier1_2_1.db

zip -r "$atelier.zip" atelier1_2_2/build.gradle
zip -r "$atelier.zip" atelier1_2_2/atelier1_2_2.db

zip -r "$atelier.zip" atelier1_2_3/build.gradle
zip -r "$atelier.zip" atelier1_2_3/atelier1_2_3.db

zip -r "$atelier.zip" atelier1_2_4/build.gradle
zip -r "$atelier.zip" atelier1_2_4/atelier1_2_4.db

zip -r "$atelier.zip" atelier1_2_5/build.gradle
zip -r "$atelier.zip" atelier1_2_5/atelier1_2_5.db



restore_dir
