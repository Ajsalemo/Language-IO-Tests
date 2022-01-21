const express = require("express");
const app = express();
const port = process.env.PORT || 3000;

const homeController = require("./controllers/homeController");
const createFileController = require("./controllers/createFileController");

// Controllers
app.use(homeController);
app.use("/file/create", createFileController);

app.listen(port, () => console.log(`Server is listening on port ${port}`));
