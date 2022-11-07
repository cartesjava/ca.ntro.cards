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
this_dir=$(readlink -f $0)
scripts_dir=$(dirname "$this_dir")
. "$scripts_dir/include.sh"
###################

if [ "$1" = "" -o "$2" = "" ]; then
    echo usage $0 ProjectName project_name
    exit 0
fi

foo_dir_prefix=foo
Foo=Foo
foo=foo

ProjectName=$1
project_name=$2

new_project(){

    parent_dir=$1
    project_name=$2
    suffix=$3

    foo_dir="validator_foo$suffix"
    project_dir="validator_"$project_name$suffix

    cd "$parent_dir"

    cp -r $foo_dir $project_dir

    cd $project_dir

    find . -type f -name "*.java" | while read i; do sed "s/$Foo/$ProjectName/g" -i "$i"; done
    find . -type f -name "*.java" | while read i; do sed "s/$foo/$project_name/g" -i "$i"; done

    sed "s/$Foo/$ProjectName/g" -i build.gradle
    sed "s/$foo/$project_name/g" -i build.gradle

    cd src/main/java/ca/ntro/cards

    mv "$foo" "$project_name"

    cd "$parent_dir"

    cd "$project_dir"

    find . -type f -name "Generer${Foo}*.java" | while read i; do mv "$i" "$(echo $i | sed s/$Foo/$ProjectName/)"; done
    find . -type f -name "Valider${Foo}*.java" | while read i; do mv "$i" "$(echo $i | sed s/$Foo/$ProjectName/)"; done

    find . -type f -name "${Foo}GeneratorBackend*.java" | while read i; do mv "$i" "$(echo $i | sed s/$Foo/$ProjectName/)"; done
    find . -type f -name "${Foo}GeneratorBackend*.java" | while read i; do mv "$i" "$(echo $i | sed s/$Foo/$ProjectName/)"; done
    find . -type f -name "${Foo}ValidatorBackend*.java" | while read i; do mv "$i" "$(echo $i | sed s/$Foo/$ProjectName/)"; done
    find . -type f -name "${Foo}Model*.java" | while read i; do mv "$i" "$(echo $i | sed s/$Foo/$ProjectName/)"; done


}

save_dir

new_project "$root_dir" "$project_name" ""

new_project "$root_dir/solutions" "$project_name" "_solution"

restore_dir




