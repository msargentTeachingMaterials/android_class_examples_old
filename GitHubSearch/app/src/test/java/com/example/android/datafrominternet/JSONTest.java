package com.example.android.datafrominternet;

import android.util.Log;

import com.example.android.datafrominternet.model.Repository;
import com.example.android.datafrominternet.utilities.JSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class JSONTest {

    String JSONString = "{" +
            "  \"total_count\": 16," +
            "  \"incomplete_results\": false," +
            "  \"items\": [" +
            "    {" +
            "      \"id\": 27824395," +
            "      \"node_id\": \"MDEwOlJlcG9zaXRvcnkyNzgyNDM5NQ==\"," +
            "      \"name\": \"qs-ws\"," +
            "      \"full_name\": \"pkinsky/qs-ws\"," +
            "      \"private\": false," +
            "      \"owner\": {" +
            "        \"login\": \"pkinsky\"," +
            "        \"id\": 2675660," +
            "        \"node_id\": \"MDQ6VXNlcjI2NzU2NjA=\"," +
            "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/2675660?v=4\"," +
            "        \"gravatar_id\": \"\"," +
            "        \"url\": \"https://api.github.com/users/pkinsky\"," +
            "        \"html_url\": \"https://github.com/pkinsky\"," +
            "        \"followers_url\": \"https://api.github.com/users/pkinsky/followers\"," +
            "        \"following_url\": \"https://api.github.com/users/pkinsky/following{/other_user}\"," +
            "        \"gists_url\": \"https://api.github.com/users/pkinsky/gists{/gist_id}\"," +
            "        \"starred_url\": \"https://api.github.com/users/pkinsky/starred{/owner}{/repo}\"," +
            "        \"subscriptions_url\": \"https://api.github.com/users/pkinsky/subscriptions\"," +
            "        \"organizations_url\": \"https://api.github.com/users/pkinsky/orgs\"," +
            "        \"repos_url\": \"https://api.github.com/users/pkinsky/repos\"," +
            "        \"events_url\": \"https://api.github.com/users/pkinsky/events{/privacy}\"," +
            "        \"received_events_url\": \"https://api.github.com/users/pkinsky/received_events\"," +
            "        \"type\": \"User\"," +
            "        \"site_admin\": false" +
            "      }," +
            "      \"html_url\": \"https://github.com/pkinsky/qs-ws\"," +
            "      \"description\": \"Quicksort in haskell over websockets. Baroque as hell.\"," +
            "      \"fork\": false," +
            "      \"url\": \"https://api.github.com/repos/pkinsky/qs-ws\"," +
            "      \"forks_url\": \"https://api.github.com/repos/pkinsky/qs-ws/forks\"," +
            "      \"keys_url\": \"https://api.github.com/repos/pkinsky/qs-ws/keys{/key_id}\"," +
            "      \"collaborators_url\": \"https://api.github.com/repos/pkinsky/qs-ws/collaborators{/collaborator}\"," +
            "      \"teams_url\": \"https://api.github.com/repos/pkinsky/qs-ws/teams\"," +
            "      \"hooks_url\": \"https://api.github.com/repos/pkinsky/qs-ws/hooks\"," +
            "      \"issue_events_url\": \"https://api.github.com/repos/pkinsky/qs-ws/issues/events{/number}\"," +
            "      \"events_url\": \"https://api.github.com/repos/pkinsky/qs-ws/events\"," +
            "      \"assignees_url\": \"https://api.github.com/repos/pkinsky/qs-ws/assignees{/user}\"," +
            "      \"branches_url\": \"https://api.github.com/repos/pkinsky/qs-ws/branches{/branch}\"," +
            "      \"tags_url\": \"https://api.github.com/repos/pkinsky/qs-ws/tags\"," +
            "      \"blobs_url\": \"https://api.github.com/repos/pkinsky/qs-ws/git/blobs{/sha}\"," +
            "      \"git_tags_url\": \"https://api.github.com/repos/pkinsky/qs-ws/git/tags{/sha}\"," +
            "      \"git_refs_url\": \"https://api.github.com/repos/pkinsky/qs-ws/git/refs{/sha}\"," +
            "      \"trees_url\": \"https://api.github.com/repos/pkinsky/qs-ws/git/trees{/sha}\"," +
            "      \"statuses_url\": \"https://api.github.com/repos/pkinsky/qs-ws/statuses/{sha}\"," +
            "      \"languages_url\": \"https://api.github.com/repos/pkinsky/qs-ws/languages\"," +
            "      \"stargazers_url\": \"https://api.github.com/repos/pkinsky/qs-ws/stargazers\"," +
            "      \"contributors_url\": \"https://api.github.com/repos/pkinsky/qs-ws/contributors\"," +
            "      \"subscribers_url\": \"https://api.github.com/repos/pkinsky/qs-ws/subscribers\"," +
            "      \"subscription_url\": \"https://api.github.com/repos/pkinsky/qs-ws/subscription\"," +
            "      \"commits_url\": \"https://api.github.com/repos/pkinsky/qs-ws/commits{/sha}\"," +
            "      \"git_commits_url\": \"https://api.github.com/repos/pkinsky/qs-ws/git/commits{/sha}\"," +
            "      \"comments_url\": \"https://api.github.com/repos/pkinsky/qs-ws/comments{/number}\"," +
            "      \"issue_comment_url\": \"https://api.github.com/repos/pkinsky/qs-ws/issues/comments{/number}\"," +
            "      \"contents_url\": \"https://api.github.com/repos/pkinsky/qs-ws/contents/{+path}\"," +
            "      \"compare_url\": \"https://api.github.com/repos/pkinsky/qs-ws/compare/{base}...{head}\"," +
            "      \"merges_url\": \"https://api.github.com/repos/pkinsky/qs-ws/merges\"," +
            "      \"archive_url\": \"https://api.github.com/repos/pkinsky/qs-ws/{archive_format}{/ref}\"," +
            "      \"downloads_url\": \"https://api.github.com/repos/pkinsky/qs-ws/downloads\"," +
            "      \"issues_url\": \"https://api.github.com/repos/pkinsky/qs-ws/issues{/number}\"," +
            "      \"pulls_url\": \"https://api.github.com/repos/pkinsky/qs-ws/pulls{/number}\"," +
            "      \"milestones_url\": \"https://api.github.com/repos/pkinsky/qs-ws/milestones{/number}\"," +
            "      \"notifications_url\": \"https://api.github.com/repos/pkinsky/qs-ws/notifications{?since,all,participating}\"," +
            "      \"labels_url\": \"https://api.github.com/repos/pkinsky/qs-ws/labels{/name}\"," +
            "      \"releases_url\": \"https://api.github.com/repos/pkinsky/qs-ws/releases{/id}\"," +
            "      \"deployments_url\": \"https://api.github.com/repos/pkinsky/qs-ws/deployments\"," +
            "      \"created_at\": \"2014-12-10T14:53:20Z\"," +
            "      \"updated_at\": \"2018-05-18T12:52:02Z\"," +
            "      \"pushed_at\": \"2014-12-10T21:03:23Z\"," +
            "      \"git_url\": \"git://github.com/pkinsky/qs-ws.git\"," +
            "      \"ssh_url\": \"git@github.com:pkinsky/qs-ws.git\"," +
            "      \"clone_url\": \"https://github.com/pkinsky/qs-ws.git\"," +
            "      \"svn_url\": \"https://github.com/pkinsky/qs-ws\"," +
            "      \"homepage\": null," +
            "      \"size\": 212," +
            "      \"stargazers_count\": 7," +
            "      \"watchers_count\": 7," +
            "      \"language\": \"Haskell\"," +
            "      \"has_issues\": true," +
            "      \"has_projects\": true," +
            "      \"has_downloads\": true," +
            "      \"has_wiki\": true," +
            "      \"has_pages\": false," +
            "      \"forks_count\": 0," +
            "      \"mirror_url\": null," +
            "      \"archived\": false," +
            "      \"open_issues_count\": 0," +
            "      \"license\": {" +
            "        \"key\": \"mit\"," +
            "        \"name\": \"MIT License\"," +
            "        \"spdx_id\": \"MIT\"," +
            "        \"url\": \"https://api.github.com/licenses/mit\"," +
            "        \"node_id\": \"MDc6TGljZW5zZTEz\"" +
            "      }," +
            "      \"forks\": 0," +
            "      \"open_issues\": 0," +
            "      \"watchers\": 7," +
            "      \"default_branch\": \"master\"," +
            "      \"score\": 32.268635" +
            "    }," +
            "    {" +
            "      \"id\": 15633969," +
            "      \"node_id\": \"MDEwOlJlcG9zaXRvcnkxNTYzMzk2OQ==\"," +
            "      \"name\": \"quicksort\"," +
            "      \"full_name\": \"rikvdkleij/quicksort\"," +
            "      \"private\": false," +
            "      \"owner\": {" +
            "        \"login\": \"rikvdkleij\"," +
            "        \"id\": 509315," +
            "        \"node_id\": \"MDQ6VXNlcjUwOTMxNQ==\"," +
            "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/509315?v=4\"," +
            "        \"gravatar_id\": \"\"," +
            "        \"url\": \"https://api.github.com/users/rikvdkleij\"," +
            "        \"html_url\": \"https://github.com/rikvdkleij\"," +
            "        \"followers_url\": \"https://api.github.com/users/rikvdkleij/followers\"," +
            "        \"following_url\": \"https://api.github.com/users/rikvdkleij/following{/other_user}\"," +
            "        \"gists_url\": \"https://api.github.com/users/rikvdkleij/gists{/gist_id}\"," +
            "        \"starred_url\": \"https://api.github.com/users/rikvdkleij/starred{/owner}{/repo}\"," +
            "        \"subscriptions_url\": \"https://api.github.com/users/rikvdkleij/subscriptions\"," +
            "        \"organizations_url\": \"https://api.github.com/users/rikvdkleij/orgs\"," +
            "        \"repos_url\": \"https://api.github.com/users/rikvdkleij/repos\"," +
            "        \"events_url\": \"https://api.github.com/users/rikvdkleij/events{/privacy}\"," +
            "        \"received_events_url\": \"https://api.github.com/users/rikvdkleij/received_events\"," +
            "        \"type\": \"User\"," +
            "        \"site_admin\": false" +
            "      }," +
            "      \"html_url\": \"https://github.com/rikvdkleij/quicksort\"," +
            "      \"description\": \"Just a quicksort in Haskell \"," +
            "      \"fork\": false," +
            "      \"url\": \"https://api.github.com/repos/rikvdkleij/quicksort\"," +
            "      \"forks_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/forks\"," +
            "      \"keys_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/keys{/key_id}\"," +
            "      \"collaborators_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/collaborators{/collaborator}\"," +
            "      \"teams_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/teams\"," +
            "      \"hooks_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/hooks\"," +
            "      \"issue_events_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/issues/events{/number}\"," +
            "      \"events_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/events\"," +
            "      \"assignees_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/assignees{/user}\"," +
            "      \"branches_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/branches{/branch}\"," +
            "      \"tags_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/tags\"," +
            "      \"blobs_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/git/blobs{/sha}\"," +
            "      \"git_tags_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/git/tags{/sha}\"," +
            "      \"git_refs_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/git/refs{/sha}\"," +
            "      \"trees_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/git/trees{/sha}\"," +
            "      \"statuses_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/statuses/{sha}\"," +
            "      \"languages_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/languages\"," +
            "      \"stargazers_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/stargazers\"," +
            "      \"contributors_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/contributors\"," +
            "      \"subscribers_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/subscribers\"," +
            "      \"subscription_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/subscription\"," +
            "      \"commits_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/commits{/sha}\"," +
            "      \"git_commits_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/git/commits{/sha}\"," +
            "      \"comments_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/comments{/number}\"," +
            "      \"issue_comment_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/issues/comments{/number}\"," +
            "      \"contents_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/contents/{+path}\"," +
            "      \"compare_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/compare/{base}...{head}\"," +
            "      \"merges_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/merges\"," +
            "      \"archive_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/{archive_format}{/ref}\"," +
            "      \"downloads_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/downloads\"," +
            "      \"issues_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/issues{/number}\"," +
            "      \"pulls_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/pulls{/number}\"," +
            "      \"milestones_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/milestones{/number}\"," +
            "      \"notifications_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/notifications{?since,all,participating}\"," +
            "      \"labels_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/labels{/name}\"," +
            "      \"releases_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/releases{/id}\"," +
            "      \"deployments_url\": \"https://api.github.com/repos/rikvdkleij/quicksort/deployments\"," +
            "      \"created_at\": \"2014-01-04T15:00:47Z\"," +
            "      \"updated_at\": \"2018-09-08T15:50:05Z\"," +
            "      \"pushed_at\": \"2018-01-22T19:46:09Z\"," +
            "      \"git_url\": \"git://github.com/rikvdkleij/quicksort.git\"," +
            "      \"ssh_url\": \"git@github.com:rikvdkleij/quicksort.git\"," +
            "      \"clone_url\": \"https://github.com/rikvdkleij/quicksort.git\"," +
            "      \"svn_url\": \"https://github.com/rikvdkleij/quicksort\"," +
            "      \"homepage\": null," +
            "      \"size\": 7," +
            "      \"stargazers_count\": 3," +
            "      \"watchers_count\": 3," +
            "      \"language\": \"Haskell\"," +
            "      \"has_issues\": true," +
            "      \"has_projects\": true," +
            "      \"has_downloads\": true," +
            "      \"has_wiki\": true," +
            "      \"has_pages\": false," +
            "      \"forks_count\": 0," +
            "      \"mirror_url\": null," +
            "      \"archived\": false," +
            "      \"open_issues_count\": 0," +
            "      \"license\": null," +
            "      \"forks\": 0," +
            "      \"open_issues\": 0," +
            "      \"watchers\": 3," +
            "      \"default_branch\": \"master\"," +
            "      \"score\": 32.150764" +
            "    }," +
            "    {" +
            "      \"id\": 4881049," +
            "      \"node_id\": \"MDEwOlJlcG9zaXRvcnk0ODgxMDQ5\"," +
            "      \"name\": \"QuicksortOnHaskell\"," +
            "      \"full_name\": \"master-q/QuicksortOnHaskell\"," +
            "      \"private\": false," +
            "      \"owner\": {" +
            "        \"login\": \"master-q\"," +
            "        \"id\": 277488," +
            "        \"node_id\": \"MDQ6VXNlcjI3NzQ4OA==\"," +
            "        \"avatar_url\": \"https://avatars1.githubusercontent.com/u/277488?v=4\"," +
            "        \"gravatar_id\": \"\"," +
            "        \"url\": \"https://api.github.com/users/master-q\"," +
            "        \"html_url\": \"https://github.com/master-q\"," +
            "        \"followers_url\": \"https://api.github.com/users/master-q/followers\"," +
            "        \"following_url\": \"https://api.github.com/users/master-q/following{/other_user}\"," +
            "        \"gists_url\": \"https://api.github.com/users/master-q/gists{/gist_id}\"," +
            "        \"starred_url\": \"https://api.github.com/users/master-q/starred{/owner}{/repo}\"," +
            "        \"subscriptions_url\": \"https://api.github.com/users/master-q/subscriptions\"," +
            "        \"organizations_url\": \"https://api.github.com/users/master-q/orgs\"," +
            "        \"repos_url\": \"https://api.github.com/users/master-q/repos\"," +
            "        \"events_url\": \"https://api.github.com/users/master-q/events{/privacy}\"," +
            "        \"received_events_url\": \"https://api.github.com/users/master-q/received_events\"," +
            "        \"type\": \"User\"," +
            "        \"site_admin\": false" +
            "      }," +
            "      \"html_url\": \"https://github.com/master-q/QuicksortOnHaskell\"," +
            "      \"description\": null," +
            "      \"fork\": false," +
            "      \"url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell\"," +
            "      \"forks_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/forks\"," +
            "      \"keys_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/keys{/key_id}\"," +
            "      \"collaborators_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/collaborators{/collaborator}\"," +
            "      \"teams_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/teams\"," +
            "      \"hooks_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/hooks\"," +
            "      \"issue_events_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/issues/events{/number}\"," +
            "      \"events_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/events\"," +
            "      \"assignees_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/assignees{/user}\"," +
            "      \"branches_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/branches{/branch}\"," +
            "      \"tags_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/tags\"," +
            "      \"blobs_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/git/blobs{/sha}\"," +
            "      \"git_tags_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/git/tags{/sha}\"," +
            "      \"git_refs_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/git/refs{/sha}\"," +
            "      \"trees_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/git/trees{/sha}\"," +
            "      \"statuses_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/statuses/{sha}\"," +
            "      \"languages_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/languages\"," +
            "      \"stargazers_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/stargazers\"," +
            "      \"contributors_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/contributors\"," +
            "      \"subscribers_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/subscribers\"," +
            "      \"subscription_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/subscription\"," +
            "      \"commits_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/commits{/sha}\"," +
            "      \"git_commits_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/git/commits{/sha}\"," +
            "      \"comments_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/comments{/number}\"," +
            "      \"issue_comment_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/issues/comments{/number}\"," +
            "      \"contents_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/contents/{+path}\"," +
            "      \"compare_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/compare/{base}...{head}\"," +
            "      \"merges_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/merges\"," +
            "      \"archive_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/{archive_format}{/ref}\"," +
            "      \"downloads_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/downloads\"," +
            "      \"issues_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/issues{/number}\"," +
            "      \"pulls_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/pulls{/number}\"," +
            "      \"milestones_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/milestones{/number}\"," +
            "      \"notifications_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/notifications{?since,all,participating}\"," +
            "      \"labels_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/labels{/name}\"," +
            "      \"releases_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/releases{/id}\"," +
            "      \"deployments_url\": \"https://api.github.com/repos/master-q/QuicksortOnHaskell/deployments\"," +
            "      \"created_at\": \"2012-07-04T05:54:56Z\"," +
            "      \"updated_at\": \"2013-12-05T02:08:51Z\"," +
            "      \"pushed_at\": \"2012-07-05T06:07:47Z\"," +
            "      \"git_url\": \"git://github.com/master-q/QuicksortOnHaskell.git\"," +
            "      \"ssh_url\": \"git@github.com:master-q/QuicksortOnHaskell.git\"," +
            "      \"clone_url\": \"https://github.com/master-q/QuicksortOnHaskell.git\"," +
            "      \"svn_url\": \"https://github.com/master-q/QuicksortOnHaskell\"," +
            "      \"homepage\": null," +
            "      \"size\": 124," +
            "      \"stargazers_count\": 1," +
            "      \"watchers_count\": 1," +
            "      \"language\": \"Haskell\"," +
            "      \"has_issues\": true," +
            "      \"has_projects\": true," +
            "      \"has_downloads\": true," +
            "      \"has_wiki\": true," +
            "      \"has_pages\": false," +
            "      \"forks_count\": 0," +
            "      \"mirror_url\": null," +
            "      \"archived\": false," +
            "      \"open_issues_count\": 0," +
            "      \"license\": null," +
            "      \"forks\": 0," +
            "      \"open_issues\": 0," +
            "      \"watchers\": 1," +
            "      \"default_branch\": \"master\"," +
            "      \"score\": 23.75885" +
            "    }," +
            "    {" +
            "      \"id\": 5185296," +
            "      \"node_id\": \"MDEwOlJlcG9zaXRvcnk1MTg1Mjk2\"," +
            "      \"name\": \"quicksort-haskell\"," +
            "      \"full_name\": \"lee-jon/quicksort-haskell\"," +
            "      \"private\": false," +
            "      \"owner\": {" +
            "        \"login\": \"lee-jon\"," +
            "        \"id\": 1002391," +
            "        \"node_id\": \"MDQ6VXNlcjEwMDIzOTE=\"," +
            "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/1002391?v=4\"," +
            "        \"gravatar_id\": \"\"," +
            "        \"url\": \"https://api.github.com/users/lee-jon\"," +
            "        \"html_url\": \"https://github.com/lee-jon\"," +
            "        \"followers_url\": \"https://api.github.com/users/lee-jon/followers\"," +
            "        \"following_url\": \"https://api.github.com/users/lee-jon/following{/other_user}\"," +
            "        \"gists_url\": \"https://api.github.com/users/lee-jon/gists{/gist_id}\"," +
            "        \"starred_url\": \"https://api.github.com/users/lee-jon/starred{/owner}{/repo}\"," +
            "        \"subscriptions_url\": \"https://api.github.com/users/lee-jon/subscriptions\"," +
            "        \"organizations_url\": \"https://api.github.com/users/lee-jon/orgs\"," +
            "        \"repos_url\": \"https://api.github.com/users/lee-jon/repos\"," +
            "        \"events_url\": \"https://api.github.com/users/lee-jon/events{/privacy}\"," +
            "        \"received_events_url\": \"https://api.github.com/users/lee-jon/received_events\"," +
            "        \"type\": \"User\"," +
            "        \"site_admin\": false" +
            "      }," +
            "      \"html_url\": \"https://github.com/lee-jon/quicksort-haskell\"," +
            "      \"description\": \"Quicksort in Haskell\"," +
            "      \"fork\": false," +
            "      \"url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell\"," +
            "      \"forks_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/forks\"," +
            "      \"keys_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/keys{/key_id}\"," +
            "      \"collaborators_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/collaborators{/collaborator}\"," +
            "      \"teams_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/teams\"," +
            "      \"hooks_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/hooks\"," +
            "      \"issue_events_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/issues/events{/number}\"," +
            "      \"events_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/events\"," +
            "      \"assignees_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/assignees{/user}\"," +
            "      \"branches_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/branches{/branch}\"," +
            "      \"tags_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/tags\"," +
            "      \"blobs_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/git/blobs{/sha}\"," +
            "      \"git_tags_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/git/tags{/sha}\"," +
            "      \"git_refs_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/git/refs{/sha}\"," +
            "      \"trees_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/git/trees{/sha}\"," +
            "      \"statuses_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/statuses/{sha}\"," +
            "      \"languages_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/languages\"," +
            "      \"stargazers_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/stargazers\"," +
            "      \"contributors_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/contributors\"," +
            "      \"subscribers_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/subscribers\"," +
            "      \"subscription_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/subscription\"," +
            "      \"commits_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/commits{/sha}\"," +
            "      \"git_commits_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/git/commits{/sha}\"," +
            "      \"comments_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/comments{/number}\"," +
            "      \"issue_comment_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/issues/comments{/number}\"," +
            "      \"contents_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/contents/{+path}\"," +
            "      \"compare_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/compare/{base}...{head}\"," +
            "      \"merges_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/merges\"," +
            "      \"archive_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/{archive_format}{/ref}\"," +
            "      \"downloads_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/downloads\"," +
            "      \"issues_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/issues{/number}\"," +
            "      \"pulls_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/pulls{/number}\"," +
            "      \"milestones_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/milestones{/number}\"," +
            "      \"notifications_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/notifications{?since,all,participating}\"," +
            "      \"labels_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/labels{/name}\"," +
            "      \"releases_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/releases{/id}\"," +
            "      \"deployments_url\": \"https://api.github.com/repos/lee-jon/quicksort-haskell/deployments\"," +
            "      \"created_at\": \"2012-07-25T22:28:15Z\"," +
            "      \"updated_at\": \"2014-02-23T20:28:09Z\"," +
            "      \"pushed_at\": \"2012-07-25T22:30:11Z\"," +
            "      \"git_url\": \"git://github.com/lee-jon/quicksort-haskell.git\"," +
            "      \"ssh_url\": \"git@github.com:lee-jon/quicksort-haskell.git\"," +
            "      \"clone_url\": \"https://github.com/lee-jon/quicksort-haskell.git\"," +
            "      \"svn_url\": \"https://github.com/lee-jon/quicksort-haskell\"," +
            "      \"homepage\": null," +
            "      \"size\": 88," +
            "      \"stargazers_count\": 1," +
            "      \"watchers_count\": 1," +
            "      \"language\": \"Haskell\"," +
            "      \"has_issues\": true," +
            "      \"has_projects\": true," +
            "      \"has_downloads\": true," +
            "      \"has_wiki\": true," +
            "      \"has_pages\": false," +
            "      \"forks_count\": 0," +
            "      \"mirror_url\": null," +
            "      \"archived\": false," +
            "      \"open_issues_count\": 0," +
            "      \"license\": null," +
            "      \"forks\": 0," +
            "      \"open_issues\": 0," +
            "      \"watchers\": 1," +
            "      \"default_branch\": \"master\"," +
            "      \"score\": 23.218887" +
            "    }," +
            "    {" +
            "      \"id\": 3896789," +
            "      \"node_id\": \"MDEwOlJlcG9zaXRvcnkzODk2Nzg5\"," +
            "      \"name\": \"quicksort-comparison\"," +
            "      \"full_name\": \"xzzulz/quicksort-comparison\"," +
            "      \"private\": false," +
            "      \"owner\": {" +
            "        \"login\": \"xzzulz\"," +
            "        \"id\": 700149," +
            "        \"node_id\": \"MDQ6VXNlcjcwMDE0OQ==\"," +
            "        \"avatar_url\": \"https://avatars1.githubusercontent.com/u/700149?v=4\"," +
            "        \"gravatar_id\": \"\"," +
            "        \"url\": \"https://api.github.com/users/xzzulz\"," +
            "        \"html_url\": \"https://github.com/xzzulz\"," +
            "        \"followers_url\": \"https://api.github.com/users/xzzulz/followers\"," +
            "        \"following_url\": \"https://api.github.com/users/xzzulz/following{/other_user}\"," +
            "        \"gists_url\": \"https://api.github.com/users/xzzulz/gists{/gist_id}\"," +
            "        \"starred_url\": \"https://api.github.com/users/xzzulz/starred{/owner}{/repo}\"," +
            "        \"subscriptions_url\": \"https://api.github.com/users/xzzulz/subscriptions\"," +
            "        \"organizations_url\": \"https://api.github.com/users/xzzulz/orgs\"," +
            "        \"repos_url\": \"https://api.github.com/users/xzzulz/repos\"," +
            "        \"events_url\": \"https://api.github.com/users/xzzulz/events{/privacy}\"," +
            "        \"received_events_url\": \"https://api.github.com/users/xzzulz/received_events\"," +
            "        \"type\": \"User\"," +
            "        \"site_admin\": false" +
            "      }," +
            "      \"html_url\": \"https://github.com/xzzulz/quicksort-comparison\"," +
            "      \"description\": \"Quicksort in haskell, go lang, javascript and experimental deathspeak\"," +
            "      \"fork\": false," +
            "      \"url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison\"," +
            "      \"forks_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/forks\"," +
            "      \"keys_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/keys{/key_id}\"," +
            "      \"collaborators_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/collaborators{/collaborator}\"," +
            "      \"teams_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/teams\"," +
            "      \"hooks_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/hooks\"," +
            "      \"issue_events_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/issues/events{/number}\"," +
            "      \"events_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/events\"," +
            "      \"assignees_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/assignees{/user}\"," +
            "      \"branches_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/branches{/branch}\"," +
            "      \"tags_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/tags\"," +
            "      \"blobs_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/git/blobs{/sha}\"," +
            "      \"git_tags_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/git/tags{/sha}\"," +
            "      \"git_refs_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/git/refs{/sha}\"," +
            "      \"trees_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/git/trees{/sha}\"," +
            "      \"statuses_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/statuses/{sha}\"," +
            "      \"languages_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/languages\"," +
            "      \"stargazers_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/stargazers\"," +
            "      \"contributors_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/contributors\"," +
            "      \"subscribers_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/subscribers\"," +
            "      \"subscription_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/subscription\"," +
            "      \"commits_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/commits{/sha}\"," +
            "      \"git_commits_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/git/commits{/sha}\"," +
            "      \"comments_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/comments{/number}\"," +
            "      \"issue_comment_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/issues/comments{/number}\"," +
            "      \"contents_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/contents/{+path}\"," +
            "      \"compare_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/compare/{base}...{head}\"," +
            "      \"merges_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/merges\"," +
            "      \"archive_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/{archive_format}{/ref}\"," +
            "      \"downloads_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/downloads\"," +
            "      \"issues_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/issues{/number}\"," +
            "      \"pulls_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/pulls{/number}\"," +
            "      \"milestones_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/milestones{/number}\"," +
            "      \"notifications_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/notifications{?since,all,participating}\"," +
            "      \"labels_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/labels{/name}\"," +
            "      \"releases_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/releases{/id}\"," +
            "      \"deployments_url\": \"https://api.github.com/repos/xzzulz/quicksort-comparison/deployments\"," +
            "      \"created_at\": \"2012-04-02T01:44:22Z\"," +
            "      \"updated_at\": \"2015-11-07T12:27:35Z\"," +
            "      \"pushed_at\": \"2015-07-12T19:14:40Z\"," +
            "      \"git_url\": \"git://github.com/xzzulz/quicksort-comparison.git\"," +
            "      \"ssh_url\": \"git@github.com:xzzulz/quicksort-comparison.git\"," +
            "      \"clone_url\": \"https://github.com/xzzulz/quicksort-comparison.git\"," +
            "      \"svn_url\": \"https://github.com/xzzulz/quicksort-comparison\"," +
            "      \"homepage\": \"\"," +
            "      \"size\": 124," +
            "      \"stargazers_count\": 1," +
            "      \"watchers_count\": 1," +
            "      \"language\": \"Go\"," +
            "      \"has_issues\": true," +
            "      \"has_projects\": true," +
            "      \"has_downloads\": true," +
            "      \"has_wiki\": true," +
            "      \"has_pages\": false," +
            "      \"forks_count\": 0," +
            "      \"mirror_url\": null," +
            "      \"archived\": false," +
            "      \"open_issues_count\": 0," +
            "      \"license\": {" +
            "        \"key\": \"other\"," +
            "        \"name\": \"NOASSERTION\"," +
            "        \"spdx_id\": \"NOASSERTION\"," +
            "        \"url\": null," +
            "        \"node_id\": \"MDc6TGljZW5zZTA=\"" +
            "      }," +
            "      \"forks\": 0," +
            "      \"open_issues\": 0," +
            "      \"watchers\": 1," +
            "      \"default_branch\": \"master\"," +
            "      \"score\": 17.55857" +
            "    }]}";

    @Test
    public void testJSONValid(){

        try {
            JSONObject jobject = new JSONObject(JSONString);
            assertTrue(!jobject.isNull("items"));

            if(jobject == null){
                Log.e("mycode", "json object null");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJSONArrayNotNull(){
        try {
            JSONObject jobject = new JSONObject(JSONString);
            JSONArray jarray = jobject.getJSONArray("items");

            assertTrue(jarray != null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testJSONParseNotEmpty(){
        ArrayList<Repository> list = JSONUtils.makeRepositoryList(JSONString);
        assertTrue(!list.isEmpty());
    }

    @Test
    public void testJSONParseReturnsCorrectNumberOfRepos(){
        ArrayList<Repository> list = JSONUtils.makeRepositoryList(JSONString);
        try {
            JSONObject jobject = new JSONObject(JSONString);
            JSONArray jarray = jobject.getJSONArray("items");

            assertTrue(list.size() == jarray.length());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testJSONParseListHasValidRepoObjects(){
        ArrayList<Repository> list = JSONUtils.makeRepositoryList(JSONString);
        Repository repo = list.get(0);
        assertTrue(repo.getName().equals("qs-ws")  && repo.getUrl().equals("https://github.com/pkinsky/qs-ws"));
    }
}




