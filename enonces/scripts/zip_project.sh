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

atelier=$1
fichier=$2

if [ "$atelier" = "" ]; then

    echo "usage: $0 atelier fichier"

fi

if [ "$fichier" = "" ]; then

    fichier="$atelier".zip

fi

save_dir

cd "$root_dir"

zip -r "$fichier" "$atelier"
zip -r "$fichier" buildSrc 
zip -r "$fichier" gradle*

zip "$fichier" settings.gradle 
zip "$fichier" .gitignore

zip "$fichier" scripts/build.sh
zip "$fichier" scripts/clean_all_projects.sh
zip "$fichier" scripts/clean_current_project.sh
zip "$fichier" scripts/clean_project.sh
zip "$fichier" scripts/clean_root.sh
zip "$fichier" scripts/deep_clean.sh
zip "$fichier" scripts/include.sh
zip "$fichier" scripts/run_commands_foreach_project.sh
zip "$fichier" scripts/ajouter_atelier.sh

restore_dir
