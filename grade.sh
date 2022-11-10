#!/bin/sh

err() {
  echo $1
  exit 1
}

DIR="subm"
CP=".\
:lib/hamcrest-core-1.3.jar\
:lib/junit-4.13.2.jar"

test ! -z "$1" \
|| err "PLEASE SUPPLY A GIT REPOSITORY"

rm -rf "${DIR}"
git clone $1 "${DIR}"

test -e "${DIR}/ListExamples.java" \
|| err "FILE NOT FOUND: ListExamples.java"

cp TestListExamples.java "${DIR}"
cp -r lib "${DIR}"
cd "${DIR}"

javac -cp "${CP}" *.java \
|| err "COMPILATION FAILED"
java -cp "${CP}" org.junit.runner.JUnitCore TestListExamples \
> ../report.txt

echo "REPORT SAVED TO: report.txt"
