#!/bin/usr/env python
import os
import re
import shutil

group = "06"

if not os.path.isdir("zips"):
    os.mkdir("zips")

for d in os.listdir():
    if not re.match(r"H\d+", d):
        continue
    out = f"zips/java_{group}_{d.lower()}"
    print(f"Zipping '{d}/src' to '{out}.zip'")
    shutil.make_archive(out, "zip", f"{d}/src")