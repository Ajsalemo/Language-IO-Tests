const express = require("express");
const router = express.Router();
const fs = require("fs");
const path = require("path");
const nanoid = require("nanoid");

const createFileController = router.get("/", (_, res, next) => {
  const id = nanoid.nanoid();
  const content = `This is a log file written with id: ${id}`;
  try {
    fs.writeFile(path.join("files", `log-rotate-${id}.txt`), content, { flag: "w+" }, (err) => {
      if (err) {
        console.log(err);
        return res.status(500).json({ error: err });
      }
      return res.json({ message: `Creating log file with id: ${id}` });
    });
  } catch (error) {
    console.log(error);
    return res.status(500).json({ error: error });
  }
});

module.exports = createFileController;
