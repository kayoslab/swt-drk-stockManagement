<body>
    <div class = "container form-signin">
        <h2 class="form-signin-heading">Anmelden</h2>

            <?php
            if (isset($_GET['type'])) {
                echo "<form class = \"form-signin\" role = \"form\" action = \"" . htmlspecialchars($_SERVER['PHP_SELF']) . "?type=" . $_GET['type'] . "\" method = \"post\">";
            } elseif (isset($_GET['id'])) {
                echo "<form class = \"form-signin\" role = \"form\" action = \"" . htmlspecialchars($_SERVER['PHP_SELF']) . "?id=" . $_GET['id'] . "\" method = \"post\">";
            } else {
                echo "<form class = \"form-signin\" role = \"form\" action = \"" . htmlspecialchars($_SERVER['PHP_SELF']) . "\" method = \"post\">";
            }
            ?>

            <h4 class="form-signin-heading"><?php echo $msg; ?></h4>

            <!--<label for="username" class="sr-only">Benutzername</label>-->
            <input type="username" name="username" class="form-control" placeholder="Benutzername" required autofocus>

            <!--<label for="password" class="sr-only">Passwort</label>-->
            <input type="password" name="password" class="form-control" placeholder="Passwort" required>

            <?php
                if (isset($_GET['type'])) {
                    echo "<input type=\"hidden\" name=\"type\" value=\"" . $_GET['type'] . "\" />";
                }
                if (isset($_GET['id'])) {
                    echo "<input type=\"hidden\" name=\"id\" value=\"" . $_GET['id'] . "\" />";
                }
            ?>

            <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit">Einloggen</button>
        </form>
    </div> <!-- /container -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./js/bootstrap.min.js"></script>
</body>
