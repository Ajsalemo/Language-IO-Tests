const express = require("express");
const app = express();
const port = process.env.PORT || 3000;

const homeController = require("./controllers/homeController");
const createFileController = require("./controllers/createFileController");
const appendFileController = require("./controllers/appendFileController");
const readFileController = require("./controllers/readFileController");

// Controllers
app.use(homeController);
app.use("/file/create", createFileController);
app.use("/file/append", appendFileController);
app.use("/file/read", readFileController);

app.listen(port, () => console.log(`Server is listening on port ${port}`));
